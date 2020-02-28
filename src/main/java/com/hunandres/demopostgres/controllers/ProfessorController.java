package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @GetMapping("/professors")
    public List<Professor> getProfessors() {
        return repository.findAll();
    }

    @GetMapping("/professor/{id}")
    public Optional<Professor> getProfessor(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping("/professor")
    public String saveProfessor(@RequestBody Professor professor) {
        repository.save(professor);
        return "Added professor with id: " + professor.getId();
    }

    @DeleteMapping("/professor/{id}")
    public String deleteProfessor(@PathVariable int id) {
        repository.deleteById(id);
        return "Professor with id: " + id + " has been deleted";
    }

}

