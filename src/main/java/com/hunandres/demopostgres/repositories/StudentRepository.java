package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.dto.StudentSearchRequest;
import com.hunandres.demopostgres.entity.QStudent;
import com.hunandres.demopostgres.entity.Student;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, QuerydslPredicateExecutor<Student> {

    static BooleanBuilder searchPredicate(StudentSearchRequest searchRequest) {

        BooleanBuilder predicate = new BooleanBuilder();

        if (searchRequest.getMajorId() != null) {
            predicate.and(QStudent.student.major.id.in(searchRequest.getMajorId()));
        }

        return predicate;

    }

}
