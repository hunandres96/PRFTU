package com.hunandres.demopostgres.repositories;

import com.hunandres.demopostgres.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Integer> {
}
