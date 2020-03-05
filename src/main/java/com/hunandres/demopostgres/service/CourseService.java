package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.entity.Course;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll();
    CourseDTO findCourseById(Integer id);
    CourseDTO saveCourse(CourseDTO courseDTO);

}
