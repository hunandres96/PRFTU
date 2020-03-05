package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.dto.ProfessorSearchRequest;
import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.entity.QProfessor;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer>{
}
