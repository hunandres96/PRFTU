package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.MajorDTO;
import com.hunandres.demopostgres.entity.Major;
import com.hunandres.demopostgres.repositories.MajorRepository;
import com.hunandres.demopostgres.service.MajorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MajorServiceImpl implements MajorService {

    private MajorRepository majorRepository;
    private ModelMapper modelMapper;

    public MajorServiceImpl(MajorRepository majorRepository, ModelMapper modelMapper) {
        this.majorRepository = majorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MajorDTO> findAll() {

        List<Major> majors = majorRepository.findAll();
        List<MajorDTO> majorDTOS = new ArrayList<>();

        majors.stream().forEach(allMajors -> {
            majorDTOS.add(modelMapper.map(allMajors, MajorDTO.class));
        });

        return majorDTOS;
    }

    @Override
    public MajorDTO findMajorById(Integer id) {

        Optional<Major> result = majorRepository.findById(id);
        Major major;

        if (result.isPresent()) {
            major = result.get();
        } else {
            throw new RuntimeException("Major with id: " + id + " was not found");
        }

        MajorDTO majorDTO = modelMapper.map(major, MajorDTO.class);

        return majorDTO;
    }
}
