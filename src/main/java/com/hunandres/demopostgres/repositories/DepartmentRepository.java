package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
