package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping("/students")
    private List<Student> getStudents() {
        return repository.findAll();
    }
}
