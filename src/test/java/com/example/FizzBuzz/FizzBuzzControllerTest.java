package com.example.FizzBuzz;

import com.example.FizzBuzz.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private FizzBuzzService service;


    @Test
    void getNumberTest() throws Exception {



        when(service.convert(anyInt())).thenReturn("number");
        mockMvc.perform(get("/api/v1/fizz-buzz/42"))
                .andExpect(status().isOk())
                .andExpect(content().string("number"));


        verify(service).convert(42);

    }

}
