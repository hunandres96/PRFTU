package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.dto.CourseSearchRequest;
import com.hunandres.demopostgres.entity.Course;
import com.hunandres.demopostgres.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Integer>, QuerydslPredicateExecutor<Course> {

//    static BooleanBuilder ccourseSearchPredicate(CourseSearchRequest courseSearchRequest) {
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (courseSearchRequest.getDepartmentId() != null) {
//            predicate.and(QCourse.course.department.id.eq(courseSearchRequest.getDepartmentId()));
//        }
//
//        return predicate;
//    }

    Page<Course> findByDepartmentId(Integer id, Pageable pageRequest);

}
