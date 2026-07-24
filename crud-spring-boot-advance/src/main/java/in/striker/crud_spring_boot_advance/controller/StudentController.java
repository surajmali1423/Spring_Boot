package in.striker.crud_spring_boot_advance.controller;


import in.striker.crud_spring_boot_advance.dto.StudentDto;
import in.striker.crud_spring_boot_advance.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    // Create the Student
    @PostMapping("/create")
    public ResponseEntity<StudentDto>createNewStudent(@RequestBody StudentDto createStudent){
         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(studentService.createStudent(createStudent));
    }

    // Get Specific Student
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        StudentDto getStudent = studentService.getStudentById(id);
        return ResponseEntity.ok(getStudent);
    }


    // Get All Student
    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        List<StudentDto> allStudent = studentService.getAllStudent();

        return ResponseEntity.ok(allStudent);
    }

    // Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id ,  @RequestBody StudentDto studentDto){
        StudentDto updateStudent = studentService.updateStudent(id , studentDto);

        if(updateStudent == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.ok(updateStudent);
    }

    // Hard Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){

         studentService.deleteStudent(id);

         return ResponseEntity.ok("Student Deleted Successfully !!!");
    }

    // Soft Delete
    @PatchMapping("/delete-softly/{id}")
    public ResponseEntity<String> deleteSoftlyById(@PathVariable Long id){
          studentService.deleteSoftlyById(id);
          return ResponseEntity.ok("Student Deleted Softly !!!");
    }
}
