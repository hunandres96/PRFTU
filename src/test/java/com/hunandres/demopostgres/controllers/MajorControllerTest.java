package com.hunandres.demopostgres.controllers;

import com.hunandres.demopostgres.dto.MajorDTO;
import com.hunandres.demopostgres.service.MajorService;
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
@WebMvcTest(MajorController.class)
public class MajorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MajorService majorService;

    @Test
    public void findAllMajorsTest() throws Exception {

        List<MajorDTO> majorDTOS = new ArrayList<>();
        majorDTOS.add(MajorDTO.builder().id(1).name("Accounting").build());
        when(majorService.findAll()).thenReturn(majorDTOS);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/majors");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(majorService, times(1)).findAll();
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

    @Test
    public void findMajorById() throws Exception {

        MajorDTO majorDTO = MajorDTO.builder().id(1).name("Marketing").build();
        when(majorService.findMajorById(1)).thenReturn(majorDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/majors/1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        verify(majorService, times(1)).findMajorById(1);
        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }

}
