package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> findAll();
    DepartmentDTO findDepartmentById(Integer id);

}
