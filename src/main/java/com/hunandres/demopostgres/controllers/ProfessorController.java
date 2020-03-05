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
    public List<ProfessorDTO> getProfessors() {
        return professorService.findAll();
    }

    @GetMapping("/professors/{id}")
    public ProfessorDTO getProfessorById(@PathVariable int id) {
        return professorService.findProfessorById(id);
    }

//    @PostMapping("/professor")
//    public String saveProfessor(@RequestBody Professor professor) {
//        repository.save(professor);
//        return "Added professor with id: " + professor.getId();
//    }
//
//    @DeleteMapping("/professor/{id}")
//    public String deleteProfessor(@PathVariable int id) {
//        repository.deleteById(id);
//        return "Professor with id: " + id + " has been deleted";
//    }

}

