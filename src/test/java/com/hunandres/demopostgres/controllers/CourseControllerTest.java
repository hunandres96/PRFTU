package com.hunandres.demopostgres.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hunandres.demopostgres.dto.CourseDTO;
import com.hunandres.demopostgres.entity.Department;
import com.hunandres.demopostgres.entity.Professor;
import com.hunandres.demopostgres.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void getCoursesTest() throws Exception {

        List<CourseDTO> courseDTOS = new ArrayList<>();
        courseDTOS.add(CourseDTO.builder()
                .id(1)
                .name("Data Programming")
                .department(Department.builder().id(1).name("Information System").build())
                .professor(Professor.builder().id(1).name("Vivek Singh").email("vivek@gmail.com").build())
                .build());
        when(courseService.findAll()).thenReturn(courseDTOS);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/courses");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(courseService, times(1)).findAll();
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

    @Test
    public void findCourseById() throws Exception {

        CourseDTO courseDTO = CourseDTO.builder()
                .id(1)
                .name("Data Programming")
                .department(Department.builder().id(1).name("Information System").build())
                .professor(Professor.builder().id(1).name("Vivek Singh").email("vivek@gmail.com").build())
                .build();
        when(courseService.findCourseById(1)).thenReturn(courseDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/courses/1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(courseService, times(1)).findCourseById(1);
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

    @Test
    public void saveCourse() throws Exception {

        CourseDTO courseDTO = CourseDTO.builder()
                .id(1)
                .name("Data Programming")
                .build();
        when(courseService.saveCourse(courseDTO)).thenReturn(courseDTO);

        // turn DTO into JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(courseDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/courses").content(string).contentType("application/json");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(courseService, times(1)).saveCourse(courseDTO);
        assertEquals(HttpStatus.CREATED.value(), mockHttpServletResponse.getStatus());

    }

}
