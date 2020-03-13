package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.MajorDTO;
import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.entity.Major;
import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.repositories.StudentRepository;
import com.hunandres.demopostgres.service.StudentService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDTO> findAll(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Student> studentPage = studentRepository.findAll(pageable);

        List<StudentDTO> studentDTOS = new ArrayList<>();

        studentPage.stream().forEach(allStudents -> {
            studentDTOS.add(modelMapper.map(allStudents, StudentDTO.class));
        });

        return studentDTOS;

    }

    @Override
    public StudentDTO findStudentById(Integer id) {

        Optional<Student> studentOptional = studentRepository.findById(id);
        Student student;

        if (studentOptional.isPresent()) {
            student = studentOptional.get();
        } else {
            throw new RuntimeException("Student with id: " + id + " was not found");
        }

        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO;

    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {

        Student student = modelMapper.map(studentDTO, Student.class);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);

    }

    @Override
    public void deleteStudentById(Integer id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }
}
