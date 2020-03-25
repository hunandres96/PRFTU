package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>, PagingAndSortingRepository<Course, Integer> {
}
