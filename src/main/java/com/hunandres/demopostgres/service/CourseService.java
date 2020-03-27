package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.dto.CourseSearchRequest;
import com.hunandres.demopostgres.entity.Course;
import com.hunandres.demopostgres.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll(Integer pageNo, Integer pageSize, String sortBy);

    List<CourseDTO> search(CourseSearchRequest courseSearchRequest);

    CourseDTO findCourseById(Integer id);
    CourseDTO saveCourse(CourseDTO courseDTO);
    void deleteCourseById(Integer id);

}
