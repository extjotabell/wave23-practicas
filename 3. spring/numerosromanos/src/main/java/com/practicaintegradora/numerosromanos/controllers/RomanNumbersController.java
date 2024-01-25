package com.practicaintegradora.numerosromanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Romans")
public class RomanNumbersController {

    @GetMapping("/decimalToRoman/{number}")
    public String decimalToRoman(@PathVariable int number) {
        return convertDecimalToRoman(number);
    }

    private String convertDecimalToRoman(int number) {
        List<Integer> decimals = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        List<String> romanSymbols = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

        StringBuilder res = new StringBuilder();
        int i = 0;

        while (number > 0) {
            if (number >= decimals.get(i)) {
                res.append(romanSymbols.get(i));
                number -= decimals.get(i);
            } else {
                i++;
            }
        }

        return res.toString();
    }
}
