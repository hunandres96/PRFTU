package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.MajorDTO;
import com.hunandres.demopostgres.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/majors")
@CrossOrigin(origins = "http://localhost:3000")
public class MajorController {

    private MajorService majorService;

    @Autowired
    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @GetMapping
    private List<MajorDTO> getMajors() {
        return majorService.findAll();
    }

    @GetMapping("/{id}")
    public MajorDTO getMajorById(@PathVariable int id) {
        return majorService.findMajorById(id);
    }
}
