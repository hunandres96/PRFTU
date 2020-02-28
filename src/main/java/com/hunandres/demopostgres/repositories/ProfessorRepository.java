package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
