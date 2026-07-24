package in.striker.crud_spring_boot_advance.service;

import in.striker.crud_spring_boot_advance.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    StudentDto getStudentById(Long id);

    StudentDto createStudent(StudentDto createStudent);

    List<StudentDto> getAllStudent();

    StudentDto updateStudent(Long id , StudentDto studentDto);

    void deleteStudent(Long id);

    void deleteSoftlyById(Long id);
}
