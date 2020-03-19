package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.entity.Major;
import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.repositories.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    @Test
    public void findAll() {

        List<Student> students = new ArrayList<>();
        Student student = Student.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@gmail.com")
                .major(Major.builder().name("Marketing").build())
                .build();
        students.add(student);

        when(studentRepository.findAll()).thenReturn(students);

        StudentDTO studentDTO = StudentDTO.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@gmail.com")
                .major(Major.builder().name("Marketing").build())
                .build();
        when(modelMapper.map(any(), eq(StudentDTO.class))).thenReturn(studentDTO);

        StudentServiceImpl studentService = new StudentServiceImpl(studentRepository, modelMapper);
        List<StudentDTO> studentDTOS = studentService.findAll();
        assertNotNull(studentDTOS);

        verify(studentRepository).findAll();
        verify(modelMapper).map(any(), eq(StudentDTO.class));
    }

    @Test
    public void findStudentById() {

        Student student = Student.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@gmail.com")
                .major(Major.builder().name("Marketing").build())
                .build();

        StudentDTO studentDTO = StudentDTO.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@gmail.com")
                .major(Major.builder().name("Marketing").build())
                .build();

        Optional<Student> optionalStudent = Optional.of(student);
        when(studentRepository.findById(1)).thenReturn(optionalStudent);
        when(modelMapper.map(student, StudentDTO.class)).thenReturn(studentDTO);

        studentServiceImpl.findStudentById(1);

        verify(studentRepository).findById(1);
        verify(modelMapper).map(student, StudentDTO.class);

    }

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@gmail.com")
                .major(Major.builder().name("Marketing").build())
                .build();
        when(studentRepository.save(student)).thenReturn(student);

        StudentDTO studentDTO = StudentDTO.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@gmail.com")
                .major(Major.builder().name("Marketing").build())
                .build();
        when(modelMapper.map(studentDTO, Student.class)).thenReturn(student);

        StudentServiceImpl studentService = new StudentServiceImpl(studentRepository, modelMapper);
        studentService.saveStudent(studentDTO);

        verify(studentRepository).save(student);
        verify(modelMapper).map(student, StudentDTO.class);

    }

    @Test
    public void deleteStudentById() {

        Student student = Student.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@gmail.com")
                .major(Major.builder().name("Marketing").build())
                .build();
        when(studentRepository.findById(1)).thenReturn(Optional.of(student));

        studentServiceImpl.deleteStudentById(1);

        verify(studentRepository).findById(1);
        verify(studentRepository).deleteById(1);

    }

}
