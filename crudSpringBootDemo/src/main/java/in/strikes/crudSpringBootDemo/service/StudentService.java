package in.strikes.crudSpringBootDemo.service;


import in.strikes.crudSpringBootDemo.dto.StudentDto;
import in.strikes.crudSpringBootDemo.dto.StudentGetDto;
import in.strikes.crudSpringBootDemo.dto.UpdateStudent;
import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.exception.DuplicateResourceException;
import in.strikes.crudSpringBootDemo.exception.ResourceNotFoundException;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private  final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    // Create New Student
    public StudentDto createStudent(StudentDto studentDto){

         Student student = modelMapper.map(studentDto , Student.class);

         if(EmailExist(student)){
              throw new DuplicateResourceException(student.getEmail()+" Email Already Exist. Enter Another Email.");
         }

        student.setDeleted(false);
        studentRepository.save(student);


         return modelMapper.map(student , StudentDto.class);
     }

    // Get Student By its id
    public StudentGetDto getStudent(Long id) {

          Student ReqStudent = studentRepository.findById(id).orElseThrow(
                  () -> new RuntimeException("The student Not Found  With Id : "+id)
          );

          return modelMapper.map(ReqStudent , StudentGetDto.class);
    }

    // Get ALL Student
    public List<StudentGetDto> findAllStudent(){
        List<Student>studentList = studentRepository.findAllByDeletedFalse();

        return studentList.stream()
                .map(student -> modelMapper.map(student , StudentGetDto.class))
                .collect(Collectors.toList());
    }

    // Update Student
    public UpdateStudent updateStudent(Long id , UpdateStudent updateStudent){
        Student existingStudent = studentRepository.findByIdAndDeletedFalse(id).orElseThrow(
                () ->  new ResourceNotFoundException("You Can't Update , This Id :  "+ id+" Not Found.")
        );

        existingStudent.setName(updateStudent.getName());
        existingStudent.setEmail(updateStudent.getEmail());
        existingStudent.setAge(updateStudent.getAge());
        existingStudent.setSubject(updateStudent.getSubject());
        existingStudent.setDeleted(false);

        studentRepository.save(existingStudent);

        return modelMapper.map(existingStudent , UpdateStudent.class);
    }

    // Delete Student
    public void deleteStudent(Long id){
         Student student = studentRepository.findById(id).orElseThrow(
                 () -> new ResourceNotFoundException("This Id Not Found : "+id)
         );

         studentRepository.deleteById(id);

    }

    // Soft Delete
    public void deleteStudentSoftly(Long id){

        Student existingStudent = studentRepository.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new ResourceNotFoundException("Student Not Found With Id : "+ id)
        );

         existingStudent.setDeleted(true);
         studentRepository.save(existingStudent);
    }

    private boolean EmailExist(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }

}
