package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.dto.StudentSearchRequest;
import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.repositories.StudentRepository;
import com.hunandres.demopostgres.service.StudentService;
import com.querydsl.core.BooleanBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDTO> findAll(StudentSearchRequest studentSearchRequest) {

        List<Student> students;

        BooleanBuilder predicate = StudentRepository.searchPredicate(studentSearchRequest);

        students = (List<Student>) studentRepository.findAll(predicate);

        List<StudentDTO> studentDTOS = new ArrayList<>();

        students.stream().forEach(student -> {
            studentDTOS.add(modelMapper.map(student, StudentDTO.class));
        });

        return studentDTOS;

    }

    @Override
    public StudentDTO findStudentById(Integer id) {

        Optional<Student> result = studentRepository.findById(id);
        Student student;

        if (result.isPresent()) {
            student = result.get();
        } else {
            throw new RuntimeException("Student with id: " + id + " was not found");
        }

        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);

        return studentDTO;

    }

}
