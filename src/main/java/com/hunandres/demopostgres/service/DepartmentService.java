package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> findAll(Integer pageNo, Integer pageSize, String sortBy);
    DepartmentDTO findDepartmentById(Integer id);

}
