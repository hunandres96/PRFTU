package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.entity.Course;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll(Integer pageNo, Integer pageSize, String sortBy);
    //List<CourseDTO> findAllByDeptId(Integer id);
    CourseDTO findCourseById(Integer id);
    CourseDTO saveCourse(CourseDTO courseDTO);
    void deleteCourseById(Integer id);

}
