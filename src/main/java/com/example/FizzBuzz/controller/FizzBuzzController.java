package com.example.FizzBuzz.controller;

import com.example.FizzBuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1")
public class FizzBuzzController {

    private FizzBuzzService fizzBuzzService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("/fizz-buzz/{number}")
    public List<String> getNumber(@PathVariable int number) {

        return fizzBuzzService.fizzBuzzConvertor(number);

    }

}
