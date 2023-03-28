package com.example.studentregistration.controller;


import com.example.studentregistration.dto.StudentDTO;
import com.example.studentregistration.model.Student;
import com.example.studentregistration.jwt.JwtTokenUtil;
import com.example.studentregistration.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger.web.SecurityConfiguration;

@RestController
@Tag(name = "Student", description = "The Student API. Contains all the operations that can be performed on a student.")


@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;






    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @PostMapping
//    public ResponseEntity<Student> save(@RequestBody StudentDTO studentDTO) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDTO));
//    }




    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.update(id, studentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Gets customer by ID",
            response = Student.class,
            notes = "Customer must exist")

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")

    @GetMapping
    public ResponseEntity<Page<Student>> getAll(Pageable pageable) {
        return  ResponseEntity.ok(studentService.getAll(pageable));
    }



}
