package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll();
    CourseDTO findCourseById(String id);

}
