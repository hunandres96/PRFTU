package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.dto.StudentSearchRequest;
import com.hunandres.demopostgres.entity.QStudent;
import com.hunandres.demopostgres.entity.Student;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
