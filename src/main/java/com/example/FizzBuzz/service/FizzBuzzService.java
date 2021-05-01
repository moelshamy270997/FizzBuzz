package com.example.FizzBuzz.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzService {

    private List<String> outputList = new ArrayList<String>();

    public List<String> fizzBuzzConvertor(int number) {

        for (int i = 1; i <= number; i++) {
            outputList.add(this.convert(i));
        }
        return outputList;
    }

    public String convert(Integer number) {
        String output = "";

        if (number % 3 == 0) {
            output += "Fizz";
        }
        if (number % 5 == 0) {
            output += "Buzz";
        }

        if (output.equals("")) {
            output = number.toString();
        }

        return output;
    }


}
