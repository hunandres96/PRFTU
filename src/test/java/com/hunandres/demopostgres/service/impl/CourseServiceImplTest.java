package com.hunandres.demopostgres.service.impl;

import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.entity.Course;
import com.hunandres.demopostgres.entity.Department;
import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.repositories.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    private CourseServiceImpl courseService;

//    @Test
//    public void searchCoursesTest() {
//
//        List<Course> courses = new ArrayList<>();
//        courses.add(Course.builder()
//                .id(1)
//                .name("Fundamentals of Financial Accounting")
//                .department(Department.builder().id(1).name("Accounting").build())
//                .professor(Professor.builder().id(1).name("Drake Perry").email("drakeperry@gmail.com").build())
//                .build());
//
//        when(courseRepository.findAll(any(Predicate.class), any(Sort.class))).thenReturn(courses);
//
//        CourseDTO courseDTO = CourseDTO.builder()
//                .id(1)
//                .name("Fundamentals of Financial Accounting")
//                .build();
//        when(modelMapper.map(any(), eq(CourseDTO.class))).thenReturn(courseDTO);
//
//        CourseSearchRequest courseSearchRequest = new CourseSearchRequest();
//        List<CourseDTO> courseDTOS = courseService.search(courseSearchRequest);
//        assertNotNull(courseDTOS);
//
//        verify(courseRepository).findAll(any(Predicate.class), any(Sort.class));
//        verify(modelMapper).map(any(), eq(CourseDTO.class));
//        assertThat(courseDTOS.size(), is(1));
//    }

    @Test
    public void findCourseById() {

        Course course = Course.builder()
                .id(1)
                .name("Fundamentals of Financial Accounting")
                .department(Department.builder().id(1).name("Accounting").build())
                .professor(Professor.builder().id(1).name("Drake Perry").email("drakeperry@gmail.com").build())
                .build();

        CourseDTO courseDTO = CourseDTO.builder()
                .id(1)
                .name("Fundamentals of Financial Accounting")
                .department(Department.builder().id(1).name("Accounting").build())
                .professor(Professor.builder().id(1).name("Drake Perry").email("drakeperry@gmail.com").build())
                .build();

        Optional<Course> optionalCourse = Optional.of(course);
        when(courseRepository.findById(1)).thenReturn(optionalCourse);
        when(modelMapper.map(course, CourseDTO.class)).thenReturn(courseDTO);

        courseService.findCourseById(1);

        verify(courseRepository).findById(1);
        verify(modelMapper).map(course, CourseDTO.class);

    }

    @Test
    public void saveCourseTest() {

        Course course = Course.builder()
                .id(1)
                .name("Fundamentals of Financial Accounting")
                .department(Department.builder().id(1).name("Accounting").build())
                .professor(Professor.builder().id(1).name("Drake Perry").email("drakeperry@gmail.com").build())
                .build();
        when(courseRepository.save(course)).thenReturn(course);

        CourseDTO courseDTO = CourseDTO.builder()
                .id(1)
                .name("Fundamentals of Financial Accounting")
                .department(Department.builder().id(1).name("Accounting").build())
                .professor(Professor.builder().id(1).name("Drake Perry").email("drakeperry@gmail.com").build())
                .build();
        when(modelMapper.map(courseDTO, Course.class)).thenReturn(course);

        CourseServiceImpl courseService = new CourseServiceImpl(courseRepository, modelMapper);
        courseService.saveCourse(courseDTO);

        verify(courseRepository).save(course);
        verify(modelMapper).map(course, CourseDTO.class);

    }

    @Test
    public void deleteCourseById() {

        Course course = Course.builder().id(1).build();
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));

        boolean result = courseService.deleteCourseById(1);

        verify(courseRepository).findById(1);
        verify(courseRepository).deleteById(1);
        assertEquals(result, true);

    }

}
