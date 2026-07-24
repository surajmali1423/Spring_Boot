package in.striker.crud_spring_boot_advance.service.implementation;

import in.striker.crud_spring_boot_advance.dto.StudentDto;
import in.striker.crud_spring_boot_advance.entity.Student;
import in.striker.crud_spring_boot_advance.repository.StudentRepository;
import in.striker.crud_spring_boot_advance.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public StudentDto createStudent(StudentDto createStudent) {

         // 1.Convert the StudentDto To Student
         Student student = modelMapper.map(createStudent , Student.class);
         student.setDelete(false);

         // 2.Save the Student
         Student saveStudent = studentRepository.save(student);

         // 3.Return Convert the Student to StudentDto
         return modelMapper.map(saveStudent , StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> student = studentRepository.findByIdAndDeleteFalse(id);
        return modelMapper.map(student , StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> StudentList = studentRepository.findAllByDeleteFalse();

        return StudentList.stream()
                .map(student -> modelMapper.map(student , StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long id , StudentDto studentDto) {
        // Find Student
         Student existingStudent = studentRepository.findByIdAndDeleteFalse(id).orElseThrow(
                 () -> new RuntimeException("Student Not Found With Id : "+ id)
         );

         // update the Existing Student
         existingStudent.setEmail(studentDto.getEmail());
         existingStudent.setAge(studentDto.getAge());
         existingStudent.setName(studentDto.getName());
         existingStudent.setSubject(studentDto.getSubject());

         // Save Student
         Student updatedStudent = studentRepository.save(existingStudent);

         // Convert the Student to StudentDto
         return modelMapper.map(updatedStudent , StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {

        // Find The Student
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student Not Found With Id : "+ id)
        );

        // Delete the Student
        studentRepository.delete(student);

    }

    @Override
    public void deleteSoftlyById(Long id) {
         Student student = studentRepository.findById(id).orElseThrow(
                 () -> new RuntimeException("Student Not Found With Id : "+ id)
         );

         student.setDelete(true);
         studentRepository.save(student);
    }
}
