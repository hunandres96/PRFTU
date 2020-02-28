package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.entity.Major;
import com.hunandres.demopostgres.repositories.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MajorController {

    @Autowired
    private MajorRepository repository;

    @GetMapping("/majors")
    private List<Major> getMajors() {
        return repository.findAll();
    }
}
