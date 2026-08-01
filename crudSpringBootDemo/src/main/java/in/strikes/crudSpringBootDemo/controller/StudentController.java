package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.dto.StudentDto;
import in.strikes.crudSpringBootDemo.dto.StudentGetDto;
import in.strikes.crudSpringBootDemo.dto.UpdateStudent;
import in.strikes.crudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

     private final StudentService studentService;


    // Create The New Student Using the Post
    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto){
         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(studentService.createStudent(studentDto));
    }
    
    // Read The Specific Student Data
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentGetDto>getStudent(@PathVariable Long id){
        StudentGetDto ReqStudent = studentService.getStudent(id);

        return ResponseEntity.ok(ReqStudent);
    }

    // Read The Student
    @GetMapping("/getAll")
    public ResponseEntity<List<StudentGetDto>> getAllStudent(){
        List<StudentGetDto>studentList = studentService.findAllStudent();
        return ResponseEntity.ok(studentList);
    }

    // Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateStudent> updateStudentById(@PathVariable Long id, @RequestBody UpdateStudent updateStudent){
       UpdateStudent updatedStudent = studentService.updateStudent(id , updateStudent);

       return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){

          studentService.deleteStudent(id);

          return ResponseEntity.noContent().build();
    }

    @PatchMapping("/delete-softly/{id}")
    public ResponseEntity<String>deleteStudentSoftly(@PathVariable Long id){
        studentService.deleteStudentSoftly(id);

        return ResponseEntity.noContent().build();
    }

}
