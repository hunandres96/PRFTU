package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.MajorDTO;
import com.hunandres.demopostgres.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MajorController {

    private MajorService majorService;

    @Autowired
    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @GetMapping("/majors")
    private List<MajorDTO> getMajors() {
        return majorService.findAll();
    }

    @GetMapping("/major/{id}")
    public MajorDTO getMajorById(@PathVariable int id) {
        return majorService.findMajorById(id);
    }
}
