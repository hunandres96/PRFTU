package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.repositories.StudentRepository;
import com.hunandres.demopostgres.service.StudentService;
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
    public List<StudentDTO> findAll() {

        List<Student> students = (List<Student>) studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();

        students.stream().forEach(allStudents -> {
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
    public boolean deleteStudentById(Integer id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
