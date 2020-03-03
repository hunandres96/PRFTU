package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<CourseDTO> getCourses() {
        return courseService.findAll();
    }

    @GetMapping("/course/{id}")
    public CourseDTO getCourseById(@PathVariable String id) {
        return courseService.findCourseById(id);
    }
}
