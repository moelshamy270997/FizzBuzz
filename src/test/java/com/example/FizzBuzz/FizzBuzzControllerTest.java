package com.example.FizzBuzz;

import com.example.FizzBuzz.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;

import static org.hamcrest.core.StringContains.containsString;
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

        when(service.fizzBuzzConvertor(anyInt())).thenReturn(Arrays.asList("number"));

        mockMvc.perform(get("/api/v1/fizz-buzz/42"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("number")));


        verify(service).fizzBuzzConvertor(42);

    }

}
