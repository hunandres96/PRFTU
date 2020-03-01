package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.repositories.StudentRepository;
import com.hunandres.demopostgres.service.ServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    @GetMapping("/students")
    private List<Student> getStudents() {
        return service.findAll();
    }

    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable Integer id) {
        return service.findStudentById(id);
    }

}
