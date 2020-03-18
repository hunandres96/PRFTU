package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {
}
