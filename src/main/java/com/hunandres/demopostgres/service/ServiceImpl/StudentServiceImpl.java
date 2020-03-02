package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.repositories.StudentRepository;
import com.hunandres.demopostgres.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findStudentById(Integer id) {

        Optional<Student> result = repository.findById(id);
        Student student;

        if (result.isPresent()) {
            student = result.get();
        } else {
            throw new RuntimeException("Student with id: " + id + " was not found");
        }

        return student;

    }

}
