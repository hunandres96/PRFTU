package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.dto.ProfessorSearchRequest;
import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.mapper.ProfessorMapper;
import com.hunandres.demopostgres.repositories.ProfessorRepository;
import com.hunandres.demopostgres.service.ProfessorService;
import com.querydsl.core.BooleanBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;
    private ProfessorMapper professorMapper;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    @Override
    public List<ProfessorDTO> findAll(ProfessorSearchRequest professorSearchRequest) {

        List<Professor> professors;

        BooleanBuilder predicate = ProfessorRepository.searchPredicate(professorSearchRequest);

        professors = (List<Professor>) professorRepository.findAll(predicate);

        List<ProfessorDTO> professorDTOS = new ArrayList<>();

        professors.stream().forEach(professor -> {
            professorDTOS.add(professorMapper.transform(professor));
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

        ProfessorDTO professorDTO = professorMapper.transform(result.get());

        return professorDTO;
    }
}
