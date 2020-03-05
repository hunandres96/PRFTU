package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("/courses/{id}")
    public CourseDTO getCourseById(@PathVariable Integer id) {
        return courseService.findCourseById(id);
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO) throws Exception {

        CourseDTO result = courseService.saveCourse(courseDTO);
        return ResponseEntity.created(new URI("localhost:8080/courses" + result.getId())).body(result);

    }
}
