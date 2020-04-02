package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.dto.CourseSearchRequest;

import java.util.List;

public interface CourseService {

    List<CourseDTO> search(CourseSearchRequest courseSearchRequest);
    CourseDTO findCourseById(Integer id);
    CourseDTO saveCourse(CourseDTO courseDTO);
    boolean deleteCourseById(Integer id);

}
