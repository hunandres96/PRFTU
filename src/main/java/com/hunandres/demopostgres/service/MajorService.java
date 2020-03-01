package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.dto.MajorDTO;

import java.util.List;

public interface MajorService {

    List<MajorDTO> findAll();

}
