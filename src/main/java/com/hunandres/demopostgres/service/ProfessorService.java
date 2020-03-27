package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.dto.ProfessorSearchRequest;

import java.util.List;

public interface ProfessorService {

    List<ProfessorDTO> findAll(Integer pageNo, Integer pageSize, String sortBy);

    List<ProfessorDTO> search(ProfessorSearchRequest professorSearchRequest);

    ProfessorDTO findProfessorById(Integer id);
    ProfessorDTO saveProfessor(ProfessorDTO professorDTO);
    void deleteProfessorById(Integer id);

}
