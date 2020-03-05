package com.hunandres.demopostgres.mapper;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.entity.Professor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    private ModelMapper modelMapper;

    @Autowired
    public ProfessorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProfessorDTO transform(Professor professor) {
        return modelMapper.map(professor, ProfessorDTO.class);
    }

    public Professor reverseTransform(ProfessorDTO professorDTO) {
        return modelMapper.map(professorDTO, Professor.class);
    }
}
