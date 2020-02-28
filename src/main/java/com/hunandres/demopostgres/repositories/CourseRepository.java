package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
