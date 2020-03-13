package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.dto.DepartmentDTO;
import com.hunandres.demopostgres.entity.Course;
import com.hunandres.demopostgres.entity.Department;
import com.hunandres.demopostgres.repositories.DepartmentRepository;
import com.hunandres.demopostgres.service.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DepartmentDTO> findAll(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Department> departments = departmentRepository.findAll(pageable);

        List<DepartmentDTO> departmentDTOS = new ArrayList<>();

        departments.stream().forEach(allDepartments -> {
            departmentDTOS.add(modelMapper.map(allDepartments, DepartmentDTO.class));
        });

        return departmentDTOS;
    }

    @Override
    public DepartmentDTO findDepartmentById(Integer id) {

        Optional<Department> result = departmentRepository.findById(id);
        Department department;

        if (result.isPresent()) {
            department = result.get();
        } else {
            throw new RuntimeException("Department with id: " + id + " was not found");
        }

        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        return departmentDTO;
    }
}
