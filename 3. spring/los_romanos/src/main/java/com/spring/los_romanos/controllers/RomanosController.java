package com.spring.los_romanos.controllers;

import com.spring.los_romanos.entities.Romano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {
    @GetMapping("/{number}")
    public String convertirNumeroDecimalARomano(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }
    @GetMapping("/api/{number}")
    public String convertDecimalToRoman(@PathVariable Integer number) {
        Romano romano = new Romano();
        return romano.convertToRomanNumber(number);
    }
}
