package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.dto.StudentSearchRequest;
import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.repositories.StudentRepository;
import com.hunandres.demopostgres.service.ServiceImpl.StudentServiceImpl;
import com.hunandres.demopostgres.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    private List<StudentDTO> getStudents(StudentSearchRequest studentSearchRequest) {
        return studentService.findAll(studentSearchRequest);
    }

    @GetMapping("/student/{id}")
    public StudentDTO findStudentById(@PathVariable Integer id) {
        return studentService.findStudentById(id);
    }

}
