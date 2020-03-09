package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @GetMapping("/professors")
    public List<ProfessorDTO> getProfessors(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return professorService.findAll(pageNo, pageSize, sortBy);
    }

    @GetMapping("/professors/{id}")
    public ProfessorDTO getProfessorById(@PathVariable int id) {
        return professorService.findProfessorById(id);
    }

    @PostMapping("/professors")
    public ProfessorDTO saveProfessor(@RequestBody ProfessorDTO professorDTO) throws Exception {
        return professorService.saveProfessor(professorDTO);
    }

    @DeleteMapping("/professors/{id}")
    public void deleteProfessor(@PathVariable int id) {
        professorService.deleteProfessorById(id);
    }

}

