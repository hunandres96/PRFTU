package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.MajorDTO;
import com.hunandres.demopostgres.service.MajorService;
import com.hunandres.demopostgres.service.ServiceImpl.MajorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MajorController {

    private MajorService service;

    public MajorController(MajorService service) {
        this.service = service;
    }

    @GetMapping("/majors")
    private List<MajorDTO> getMajors() {
        return service.findAll();
    }
}
