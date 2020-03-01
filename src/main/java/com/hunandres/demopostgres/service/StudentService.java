package com.hunandres.demopostgres.service;

import com.hunandres.demopostgres.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    Student findStudentById(Integer id);

}
