package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.dto.StudentSearchRequest;
import com.hunandres.demopostgres.entity.Student;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudentRepository extends JpaRepository<Student, Integer> {

//    static BooleanBuilder searchPredicate(StudentSearchRequest searchRequest) {
//
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (searchRequest.getCourseId() != null) {
//            predicate.and()
//        }
//
//        if () {
//
//        }
//
//
//
//    }

}
