//package com.hunandres.demopostgres.service.ServiceImpl;
//
//import com.hunandres.demopostgres.dto.MajorDTO;
//import com.hunandres.demopostgres.entity.Major;
//import com.hunandres.demopostgres.repositories.MajorRepository;
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
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RunWith(MockitoJUnitRunner.class)
//public class MajorServiceImplTest {
//
//    @Mock
//    private MajorRepository majorRepository;
//
//    @Mock
//    ModelMapper modelMapper;
//
//    @InjectMocks
//    private MajorServiceImpl majorService;
//
//    @Test
//    public void findAllMajorsTest() {
//
//        List<Major> majors = new ArrayList<>();
//        majors.add(Major.builder()
//                .id(1)
//                .name("Marketing")
//                .build());
//        when(majorRepository.findAll()).thenReturn(majors);
//
//        MajorDTO majorDTO = MajorDTO.builder()
//                .id(1)
//                .name("Marketing")
//                .build();
//        when(modelMapper.map(any(), eq(MajorDTO.class))).thenReturn(majorDTO);
//
//        MajorServiceImpl majorService = new MajorServiceImpl(majorRepository, modelMapper);
//        List<MajorDTO> majorDTOS = majorService.findAll();
//        assertNotNull(majorDTOS);
//
//        verify(majorRepository).findAll();
//        verify(modelMapper).map(any(), eq(MajorDTO.class));
//
//    }
//
//    @Test
//    public void findMajorById() {
//
//        Major major = Major.builder()
//                .id(1)
//                .name("Marketing")
//                .build();
//
//        MajorDTO majorDTO = MajorDTO.builder()
//                .id(1)
//                .name("Marketing")
//                .build();
//
//        Optional<Major> optionalMajor = Optional.of(major);
//        when(majorRepository.findById(1)).thenReturn(optionalMajor);
//        when(modelMapper.map(major, MajorDTO.class)).thenReturn(majorDTO);
//
//        majorService.findMajorById(1);
//
//        verify(majorRepository).findById(1);
//        verify(modelMapper).map(major, MajorDTO.class);
//
//    }
//}
