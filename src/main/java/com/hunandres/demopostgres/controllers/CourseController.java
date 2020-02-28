package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.entity.Course;
import com.hunandres.demopostgres.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return repository.findAll();
    }
}
