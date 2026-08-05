package in.striker.SpringFilters.controller;

import in.striker.SpringFilters.dto.StudentDto;
import in.striker.SpringFilters.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String>createStudent(@RequestBody StudentDto studentDto){
         studentService.createStudent(studentDto);

         return  ResponseEntity.ok("Done");
    }
}
