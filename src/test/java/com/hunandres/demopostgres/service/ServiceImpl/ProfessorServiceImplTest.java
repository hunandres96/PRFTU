package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.repositories.ProfessorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProfessorServiceImplTest {

    @Mock
    private ProfessorRepository professorRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    public void findAllProfessorsTest() {

        List<Professor> professors = new ArrayList<>();
        professors.add(Professor.builder()
                .id(1)
                .professor_name("Drake Perry")
                .professor_email("drakeperry@umsl.edu")
                .build());
        when(professorRepository.findAll()).thenReturn(professors);

        ProfessorDTO professorDTO = ProfessorDTO.builder()
                .id(1)
                .professor_name("Drake Perry")
                .professor_email("drakeperry@umsl.edu")
                .build();
        when(modelMapper.map(any(), eq(ProfessorDTO.class))).thenReturn(professorDTO);

        ProfessorServiceImpl professorService = new ProfessorServiceImpl(professorRepository, modelMapper);
        List<ProfessorDTO> professorDTOS = professorService.findAll();
        assertNotNull(professorDTOS);

        verify(professorRepository).findAll();
        verify(modelMapper).map(any(), eq(ProfessorDTO.class));
    }

}
