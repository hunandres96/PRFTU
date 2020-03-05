package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.DepartmentDTO;
import com.hunandres.demopostgres.service.DepartmentService;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    public void findAllDepartmentsTest() throws Exception {

        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        departmentDTOS.add(DepartmentDTO.builder().id(1).department_name("Marketing").build());
        when(departmentService.findAll()).thenReturn(departmentDTOS);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/departments");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(departmentService, times(1)).findAll();
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

    @Test
    public void findDepartmentById() throws Exception {

        DepartmentDTO departmentDTO = DepartmentDTO.builder().id(1).department_name("Marketing").build();
        when(departmentService.findDepartmentById(1)).thenReturn(departmentDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/departments/1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(departmentService, times(1)).findDepartmentById(1);
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

}
