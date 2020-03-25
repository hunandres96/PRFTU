package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll(Integer pageNo, Integer pageSize, String sortBy);
    CourseDTO findCourseById(Integer id);
    CourseDTO saveCourse(CourseDTO courseDTO);
    void deleteCourseById(Integer id);

}
