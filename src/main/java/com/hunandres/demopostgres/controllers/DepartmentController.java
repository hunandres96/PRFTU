package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.DepartmentDTO;
import com.hunandres.demopostgres.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> getDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("departments/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable int id) {
        return departmentService.findDepartmentById(id);
    }
}
