package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.dto.CourseSearchRequest;
import com.hunandres.demopostgres.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> search(CourseSearchRequest courseSearchRequest) {
        return courseService.search(courseSearchRequest);
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable Integer id) {
        return courseService.findCourseById(id);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO) throws Exception {

        CourseDTO result = courseService.saveCourse(courseDTO);
        return ResponseEntity.created(new URI("localhost:8080/courses" + result.getId())).body(result);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourseById(@PathVariable Integer id) {

        boolean result = courseService.deleteCourseById(id);
        if (result) {
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } else {
            return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }
    }
}


