package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.dto.ProfessorSearchRequest;
import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.entity.QProfessor;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Integer>, QuerydslPredicateExecutor<Professor> {

    Page<Professor> findByDepartmentId(Integer id, Pageable pageable);
}

//    static BooleanBuilder professorSearchRequest(ProfessorSearchRequest professorSearchRequest) {
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (professorSearchRequest.getDepartmentId() != null) {
//            predicate.and(QProfessor.professor.department.id.in(professorSearchRequest.getDepartmentId()));
//        }
//
//        return predicate;
//    }
