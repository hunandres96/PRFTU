package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.dto.ProfessorSearchRequest;
import com.hunandres.demopostgres.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfessorController {

    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @GetMapping
    public List<ProfessorDTO> getProfessors(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return professorService.findAll(pageNo, pageSize, sortBy);
    }

    @GetMapping("/byDepartments")
    public List<ProfessorDTO> getProfessorsByDepartment(ProfessorSearchRequest professorSearchRequest) {
        return professorService.search(professorSearchRequest);
    }

    @GetMapping("/{id}")
    public ProfessorDTO getProfessorById(@PathVariable int id) {
        return professorService.findProfessorById(id);
    }

    @PostMapping
    public ProfessorDTO saveProfessor(@RequestBody ProfessorDTO professorDTO) {
        return professorService.saveProfessor(professorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable int id) {
        professorService.deleteProfessorById(id);
    }

}

