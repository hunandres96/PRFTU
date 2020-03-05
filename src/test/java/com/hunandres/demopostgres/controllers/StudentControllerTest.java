package com.hunandres.demopostgres.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        when(studentService.findAll()).thenReturn(studentDTOS);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(studentService, times(1)).findAll();
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

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(studentService, times(1)).findStudentById(1);
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

    @Test
    public void saveStudent() throws Exception {

        StudentDTO studentDTO = StudentDTO.builder()
                .id(1)
                .student_name("Miguel Hun")
                .student_email("miguelhun@umsl.edu")
                .build();
        when(studentService.saveStudent(studentDTO)).thenReturn(studentDTO);

        // turn DTO into JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(studentDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/students").content(string).contentType("application/json");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(studentService, times(1)).saveStudent(studentDTO);
        assertEquals(HttpStatus.CREATED.value(), mockHttpServletResponse.getStatus());

    }

    @Test
    public void deleteStudentById_OK() throws Exception {

        when(studentService.deleteStudentById(1)).thenReturn(true);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/students/1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(studentService, times(1)).deleteStudentById(1);
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

    @Test
    public void deleteStudentById_NOT_FOUND() throws Exception {

        when(studentService.deleteStudentById(1)).thenReturn(false);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/students/1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(studentService, times(1)).deleteStudentById(1);
        assertEquals(HttpStatus.NOT_FOUND.value(), mockHttpServletResponse.getStatus());

    }

}
