package com.numerosromanos.ejercicio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class NumbersController {
    HashMap<Integer, String> romanNumbersMapping = new HashMap<>();
    int[] romanEquivalents = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};


    public NumbersController() {
        romanNumbersMapping.put(1, "I");
        romanNumbersMapping.put(4, "IV");
        romanNumbersMapping.put(5, "V");
        romanNumbersMapping.put(9, "IX");
        romanNumbersMapping.put(10, "X");
        romanNumbersMapping.put(40, "XL");
        romanNumbersMapping.put(50, "L");
        romanNumbersMapping.put(90, "XC");
        romanNumbersMapping.put(100, "C");
        romanNumbersMapping.put(400, "CD");
        romanNumbersMapping.put(500, "D");
        romanNumbersMapping.put(900, "CM");
        romanNumbersMapping.put(1000, "M");
    }

    @GetMapping ("/{number}")
    public String getRomanNumber(@PathVariable int number) {
        int difference = number;
        StringBuilder result = new StringBuilder();
        while (difference > 0) {
            for (int i: romanEquivalents) {
                if (i <= difference) {
                    difference -= i;
                    result.append(romanNumbersMapping.get(i));
                    break;
                }
            }
        }

        return result.toString();
    }
}
