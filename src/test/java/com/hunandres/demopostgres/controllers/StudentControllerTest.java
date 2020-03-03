package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.StudentDTO;
import com.hunandres.demopostgres.service.StudentService;
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
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void getStudentsTest() throws Exception {

        List<StudentDTO> studentDTOS = new ArrayList<>();
        studentDTOS.add(StudentDTO.builder()
            .id(1)
            .student_name("Miguel Hun")
            .student_email("miguelhun@umsl.edu")
            .build());
        when(studentService.findAll(any())).thenReturn(studentDTOS);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(studentService, times(1)).findAll(any());
        //verifyNoInteractions(studentService);
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

    @Test
    public void findStudentById() throws Exception {

        StudentDTO studentDTO = StudentDTO.builder()
                .id(1)
                .student_name("Miguel Hun")
                .student_email("miguelhun@umsl.edu")
                .build();
        when(studentService.findStudentById(1)).thenReturn(studentDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/student/1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(studentService, times(1)).findStudentById(1);
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

}
