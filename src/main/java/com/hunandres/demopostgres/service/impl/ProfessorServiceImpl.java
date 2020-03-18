package com.hunandres.demopostgres.service.impl;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.repositories.ProfessorRepository;
import com.hunandres.demopostgres.service.ProfessorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository, ModelMapper modelMapper) {
        this.professorRepository = professorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProfessorDTO> findAll(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Professor> professorPage = professorRepository.findAll(pageable);

        List<ProfessorDTO> professorDTOS = new ArrayList<>();

        professorPage.stream().forEach(allProfessors -> {
            professorDTOS.add(modelMapper.map(allProfessors, ProfessorDTO.class));
        });

        return professorDTOS;
    }

    @Override
    public ProfessorDTO findProfessorById(Integer id) {

        Optional<Professor> result = professorRepository.findById(id);
        Professor professor;

        if (result.isPresent()) {
            professor = result.get();
        } else {
            throw new RuntimeException("Professor with id: " + id + " was not found");
        }

        ProfessorDTO professorDTO = modelMapper.map(professor, ProfessorDTO.class);
        return professorDTO;
    }

    @Override
    public ProfessorDTO saveProfessor(ProfessorDTO professorDTO) {

        Professor professor = modelMapper.map(professorDTO, Professor.class);
        professor = professorRepository.save(professor);
        return modelMapper.map(professor, ProfessorDTO.class);

    }

    @Override
    public void deleteProfessorById(Integer id) {

        Optional<Professor> optionalProfessor = professorRepository.findById(id);

        if (optionalProfessor.isPresent()) {
            professorRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }

    }
}
