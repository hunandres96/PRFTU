package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    private Page<StudentDTO> getStudents(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return studentService.findAll(pageNo, pageSize, sortBy);
    }

    @GetMapping("/{id}")
    public StudentDTO findStudentById(@PathVariable Integer id) {
        return studentService.findStudentById(id);
    }

    @PostMapping
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return studentService.saveStudent(studentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }

}
