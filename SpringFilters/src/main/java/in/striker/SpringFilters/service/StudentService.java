package in.striker.SpringFilters.service;

import in.striker.SpringFilters.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(StudentDto studentDto){
        System.out.println(studentDto.getName());
        System.out.println(studentDto.getEmail());
    }
}
