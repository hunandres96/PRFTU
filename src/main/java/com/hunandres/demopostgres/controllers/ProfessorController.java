package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.repositories.ProfessorRepository;
import com.hunandres.demopostgres.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/professor/{id}")
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

