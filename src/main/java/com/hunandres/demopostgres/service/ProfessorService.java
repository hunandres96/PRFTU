package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.ProfessorDTO;

import java.util.List;

public interface ProfessorService {

    List<ProfessorDTO> findAll();
    ProfessorDTO findProfessorById(Integer id);

}
