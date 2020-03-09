package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    private List<StudentDTO> getStudents(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return studentService.findAll(pageNo, pageSize, sortBy);
    }

    @GetMapping("/students/{id}")
    public StudentDTO findStudentById(@PathVariable Integer id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("/students")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return studentService.saveStudent(studentDTO);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }

}
