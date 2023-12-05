package com.meli.romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RomanosRestController {
    private final Integer[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] equivatents = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @GetMapping("/{num}")
    public String decimalToRoman(@PathVariable Integer num) {
        List<String> result = new ArrayList<>();
        int currentDigit = 0;

        while (num != 0) {
            int numDigit = (int) Math.floor((double) num / numbers[currentDigit]);
            num %= numbers[currentDigit];

            for (int i = 0; i < numDigit; i++) result.add(equivatents[currentDigit]);

            currentDigit++;
        }

        return String.join("", result);
    }
}
