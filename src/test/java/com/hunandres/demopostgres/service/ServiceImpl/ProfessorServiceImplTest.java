//package com.hunandres.demopostgres.service.ServiceImpl;
//
//import com.hunandres.demopostgres.dto.ProfessorDTO;
//import com.hunandres.demopostgres.entity.Department;
//import com.hunandres.demopostgres.entity.Professor;
//import com.hunandres.demopostgres.repositories.ProfessorRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.modelmapper.ModelMapper;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ProfessorServiceImplTest {
//
//    @Mock
//    private ProfessorRepository professorRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @InjectMocks
//    private ProfessorServiceImpl professorServiceImpl;
//
//    @Test
//    public void findAllProfessorsTest() {
//
//        List<Professor> professors = new ArrayList<>();
//        Professor professor = Professor.builder()
//                .id(1)
//                .name("Drake Perry")
//                .email("drakeperry@umsl.edu")
//                .department(Department.builder().name("Marketing").build())
//                .build();
//        professors.add(professor);
//        when(professorRepository.findAll()).thenReturn(professors);
//
//        ProfessorDTO professorDTO = ProfessorDTO.builder()
//                .id(1)
//                .name("Drake Perry")
//                .email("drakeperry@umsl.edu")
//                .build();
//        when(modelMapper.map(any(), eq(ProfessorDTO.class))).thenReturn(professorDTO);
//
//        ProfessorServiceImpl professorService = new ProfessorServiceImpl(professorRepository, modelMapper);
//        List<ProfessorDTO> professorDTOS = professorService.findAll();
//        assertNotNull(professorDTOS);
//
//        verify(professorRepository).findAll();
//        verify(modelMapper).map(any(), eq(ProfessorDTO.class));
//    }
//
//    @Test
//    public void findProfessorById() {
//
//        Professor professor = Professor.builder()
//                .id(1)
//                .name("Drake Perry")
//                .email("drakeperry@umsl.edu")
//                .build();
//
//        ProfessorDTO professorDTO = ProfessorDTO.builder()
//                .id(1)
//                .name("Drake Perry")
//                .email("drakeperry@umsl.edu")
//                .build();
//
//        Optional<Professor> optionalProfessor = Optional.of(professor);
//        when(professorRepository.findById(1)).thenReturn(optionalProfessor);
//        when(modelMapper.map(professor, ProfessorDTO.class)).thenReturn(professorDTO);
//
//        professorServiceImpl.findProfessorById(1);
//
//        verify(professorRepository).findById(1);
//        verify(modelMapper).map(professor, ProfessorDTO.class);
//
//    }
//
//    @Test
//    public void saveProfessor() {
//
//        Professor professor = Professor.builder()
//                .id(1)
//                .name("Drake Perry")
//                .email("drakeperry@umsl.edu")
//                .build();
//        when(professorRepository.save(professor)).thenReturn(professor);
//
//        ProfessorDTO professorDTO = ProfessorDTO.builder()
//                .id(1)
//                .name("Drake Perry")
//                .email("drakeperry@umsl.edu")
//                .build();
//        when(modelMapper.map(professorDTO, Professor.class)).thenReturn(professor);
//
//        ProfessorServiceImpl professorService = new ProfessorServiceImpl(professorRepository, modelMapper);
//        professorService.saveProfessor(professorDTO);
//
//        verify(professorRepository).save(professor);
//        verify(modelMapper).map(professor, ProfessorDTO.class);
//
//    }
//
//    @Test
//    public void deleteProfessorById() {
//
//        Professor professor = Professor.builder()
//                .id(1)
//                .name("Drake Perry")
//                .email("drakeperry@umsl.edu")
//                .build();
//        when(professorRepository.findById(1)).thenReturn(Optional.of(professor));
//
//        professorServiceImpl.deleteProfessorById(1);
//
//        verify(professorRepository).findById(1);
//        verify(professorRepository).deleteById(1);
//
//    }
//
//}
