package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>, PagingAndSortingRepository<Department, Integer> {
}
