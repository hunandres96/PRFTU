package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.dto.StudentSearchRequest;
import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.mapper.StudentMapper;
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
    private StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> findAll(StudentSearchRequest studentSearchRequest) {

        List<Student> students;

        BooleanBuilder predicate = StudentRepository.searchPredicate(studentSearchRequest);

        students = (List<Student>) studentRepository.findAll(predicate);

        List<StudentDTO> studentDTOS = new ArrayList<>();

        students.stream().forEach(student -> {
            studentDTOS.add(studentMapper.transform(student));
        });

        return studentDTOS;

    }

    @Override
    public StudentDTO findStudentById(Integer id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (!studentOptional.isPresent()) {
            throw new RuntimeException("Student with id: " + id + " was not found");
        }

        StudentDTO studentDTO = studentMapper.transform(studentOptional.get());
        return studentDTO;



    }

}
