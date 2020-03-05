package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class StudentController {

    private StudentService studentService;

    @GetMapping("/students")
    private List<StudentDTO> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public StudentDTO findStudentById(@PathVariable Integer id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO) throws Exception {

        StudentDTO result = studentService.saveStudent(studentDTO);
        return ResponseEntity.created(new URI("localhost:8080/students" + result.getId())).body(result);

    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudentById(@PathVariable Integer id) {

        boolean result = studentService.deleteStudentById(id);

        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
