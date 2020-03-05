package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.dto.ProfessorSearchRequest;

import java.util.List;

public interface ProfessorService {

    List<ProfessorDTO> findAll(ProfessorSearchRequest professorSearchRequest);
    ProfessorDTO findProfessorById(Integer id);

}
