package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.DepartmentDTO;
import com.hunandres.demopostgres.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentDTO> getDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable int id) {
        return departmentService.findDepartmentById(id);
    }
}
