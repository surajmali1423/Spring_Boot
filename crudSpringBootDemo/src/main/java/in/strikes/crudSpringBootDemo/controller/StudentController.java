package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(studentService.createStudent(student));
    }
    
    // Read The Specific Student Data
    @GetMapping("/get/{id}")
    public ResponseEntity<Student>getStudent(@PathVariable Long id){
        Student ReqStudent = studentService.getStudent(id);
        if(ReqStudent == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ReqStudent);
    }

    // Read The Student
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student>studentList = studentService.findAllStudent();

        if(studentList.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(studentList);
    }

    // Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @RequestBody Student updateStudent){
       Student updatedStudent = studentService.updateStudent(id , updateStudent);

       return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){

          Boolean isDeleted =  studentService.deleteStudent(id);

          if(!isDeleted) return ResponseEntity.notFound().build();

          return ResponseEntity.ok("Record Delete Successfully !!!");
    }
}
