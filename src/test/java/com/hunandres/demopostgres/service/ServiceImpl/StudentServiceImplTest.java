package com.hunandres.demopostgres.service.ServiceImpl;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.dto.StudentSearchRequest;
import com.hunandres.demopostgres.entity.Major;
import com.hunandres.demopostgres.entity.Student;
import com.hunandres.demopostgres.mapper.StudentMapper;
import com.hunandres.demopostgres.repositories.StudentRepository;
import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    @Test
    public void findAll() {

        List<Student> students = new ArrayList<>();
        Student student = Student.builder()
                .id(1)
                .student_name("John Doe")
                .student_email("johndoe@gmail.com")
                .major(Major.builder().major_name("Marketing").build())
                .build();
        students.add(student);

        when(studentRepository.findAll(any(Predicate.class))).thenReturn(students);

        StudentDTO studentDTO = StudentDTO.builder()
                .id(1)
                .student_name("John Doe")
                .student_email("johndoe@gmail.com")
                .major(Major.builder().major_name("Marketing").build())
                .build();
        when(studentMapper.transform(student)).thenReturn(studentDTO);

        StudentSearchRequest studentSearchRequest = new StudentSearchRequest();
        List<StudentDTO> studentDTOS = studentServiceImpl.findAll(studentSearchRequest);

        assertNotNull(studentDTOS);
        verify(studentRepository).findAll(any(Predicate.class));
        verify(studentMapper).transform(any());
        assertThat(studentDTOS.size(), is(1));
        assertThat(studentDTOS.get(0).getId(), is(1));
    }

    @Test
    public void findStudentById() {

        Student student = Student.builder()
                .id(1)
                .student_name("John Doe")
                .student_email("johndoe@gmail.com")
                .major(Major.builder().major_name("Marketing").build())
                .build();

        StudentDTO studentDTO = StudentDTO.builder()
                .id(1)
                .student_name("John Doe")
                .student_email("johndoe@gmail.com")
                .major(Major.builder().major_name("Marketing").build())
                .build();

        Optional<Student> optionalStudent = Optional.of(student);
        when(studentRepository.findById(1)).thenReturn(optionalStudent);
        when(studentMapper.transform(student)).thenReturn(studentDTO);

        studentServiceImpl.findStudentById(1);

        verify(studentRepository).findById(1);
        verify(studentMapper).transform(any());

    }

}
