package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Major;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepository extends CrudRepository<Major, Integer> {
}
