package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer>{
}
