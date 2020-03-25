package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Integer> {
}
