package com.hunandres.demopostgres.mapper;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.entity.Major;
import com.hunandres.demopostgres.entity.Student;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class StudentMapperTest {

    private StudentMapper studentMapper = new StudentMapper(new ModelMapper());

    @Test
    public void student_to_studentDTO() {

        Student student = new Student();
        student.setId(1);
        student.setStudent_name("John Doe");
        student.setStudent_email("johndoe@gmail.com");
        student.setMajor(Major.builder().id(1).major_name("Marketing").build());

        StudentDTO studentDTO = studentMapper.transform(student);

        assertEquals(student.getId(), studentDTO.getId());
        assertEquals(student.getStudent_name(), studentDTO.getStudent_name());
        assertEquals(student.getStudent_email(), studentDTO.getStudent_email());
        assertEquals(student.getMajor(), studentDTO.getMajor());

    }

    @Test
    public void studentDTO_to_student() {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1);
        studentDTO.setStudent_name("John Doe");
        studentDTO.setStudent_email("johndoe@gmail.com");
        studentDTO.setMajor(Major.builder().id(1).major_name("Marketing").build());

        Student student = studentMapper.reverseTransform(studentDTO);

        assertEquals(studentDTO.getId(), student.getId());
        assertEquals(studentDTO.getStudent_name(), student.getStudent_name());
        assertEquals(studentDTO.getStudent_email(), student.getStudent_email());
        assertEquals(studentDTO.getMajor(), student.getMajor());

    }

}
