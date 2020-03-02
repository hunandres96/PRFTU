package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.MajorDTO;
import com.hunandres.demopostgres.entity.Major;
import com.hunandres.demopostgres.repositories.MajorRepository;
import com.hunandres.demopostgres.service.ServiceImpl.MajorServiceImpl;
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
public class MajorServiceImplTest {

    @Mock
    private MajorRepository majorRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    public void findAllMajorsTest() {

        List<Major> majors = new ArrayList<>();
        majors.add(Major.builder()
                .id(1)
                .major_name("Accounting")
                .build());
        when(majorRepository.findAll()).thenReturn(majors);

        MajorDTO majorDTO = MajorDTO.builder()
                .id(1)
                .major_name("Accounting")
                .build();
        when(modelMapper.map(any(), eq(MajorDTO.class))).thenReturn(majorDTO);

        MajorServiceImpl majorService = new MajorServiceImpl(majorRepository, modelMapper);
        List<MajorDTO> majorDTOS = majorService.findAll();
        assertNotNull(majorDTOS);

        verify(majorRepository).findAll();
        verify(modelMapper).map(any(), eq(MajorDTO.class));

    }
}
