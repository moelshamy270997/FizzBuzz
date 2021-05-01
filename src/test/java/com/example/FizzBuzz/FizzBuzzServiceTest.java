package com.example.FizzBuzz;

import com.example.FizzBuzz.service.FizzBuzzService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FizzBuzzServiceTest {

    @Autowired
    private FizzBuzzService service;

    @ParameterizedTest
    @CsvSource({"1, 1", "3, Fizz","5, Buzz", "15, FizzBuzz"})
    void fizzBuzzConvertTest(int number, String expected) {

        // when
        String output = service.convert(number);

        // then
        assertThat(output).isEqualTo(expected);
    }

}
