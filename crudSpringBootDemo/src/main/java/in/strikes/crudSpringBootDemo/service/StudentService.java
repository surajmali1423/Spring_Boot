package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private  final StudentRepository studentRepository;

    // Create New Student
    public Student createStudent(Student student){
          return studentRepository.save(student);

    }

    // Get Student By its id
    public Student getStudent(Long id){

         Optional<Student>allStudent = studentRepository.findById(id);
        return allStudent.orElse(null);

    }

    // Get ALL Student
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    // Update Student
    public Student updateStudent(Long id , Student updateStudent){
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () ->  new RuntimeException("Student Not Found"+ id)
        );

        existingStudent.setName(updateStudent.getName());
        existingStudent.setEmail(updateStudent.getEmail());
        existingStudent.setRoll_no(updateStudent.getRoll_no());
        existingStudent.setAge(updateStudent.getAge());
        existingStudent.setSubject(updateStudent.getSubject());

        return studentRepository.save(existingStudent);
    }

    // Delete Student
    public Boolean deleteStudent(Long id){
         Boolean isStudent = studentRepository.existsById(id);

         if(!isStudent) return false;

         studentRepository.deleteById(id);

         return true;
    }
}
