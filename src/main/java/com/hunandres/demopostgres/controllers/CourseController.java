package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.dto.CourseSearchRequest;
import com.hunandres.demopostgres.entity.Course;
import com.hunandres.demopostgres.entity.Department;
import com.hunandres.demopostgres.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getCourses(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "100") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
            //@RequestParam(value = "deptId") Integer deptId
//            @RequestParam(required =  false) Integer professorId,
//            @RequestParam(required = false) String name
    ) {
        return courseService.findAll(pageNo, pageSize, sortBy);
    }

    //localhost:8080/courses?deptId=5
    //localhost:8080/courses?professorId=20

    //department/{id}/courses/
    //courses?deptId=

    @GetMapping("/byDepartments")
    public List<CourseDTO> getCoursesByDepartment(CourseSearchRequest courseSearchRequest) {
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
    public void deleteCourseById(@PathVariable Integer id) {
        courseService.deleteCourseById(id);
    }
}
