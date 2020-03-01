package com.hunandres.demopostgres.mapper;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private ModelMapper modelMapper;

    @Autowired
    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StudentDTO transform(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    public Student reverseTransform(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }

}
