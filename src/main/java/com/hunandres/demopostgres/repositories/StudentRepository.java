package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
