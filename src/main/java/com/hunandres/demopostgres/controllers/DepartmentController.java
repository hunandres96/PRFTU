package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.entity.Department;
import com.hunandres.demopostgres.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository repository;

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return repository.findAll();
    }
}
