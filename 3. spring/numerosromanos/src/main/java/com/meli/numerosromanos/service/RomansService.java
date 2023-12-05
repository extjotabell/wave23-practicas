package com.meli.numerosromanos.service;

import org.springframework.stereotype.Service;

@Service
public class RomansService {
    public String getRomanNumber(int decimalNumber){
        if (decimalNumber <= 0 || decimalNumber > 3999) {
            return "Number out of range for Roman numerals";
        }

        int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumeral = new StringBuilder();

        int i = 0;
        while (decimalNumber > 0) {
            while (decimalNumber >= decimalValues[i]) {
                decimalNumber -= decimalValues[i];
                romanNumeral.append(romanSymbols[i]);
            }
            i++;
        }

        return romanNumeral.toString();
    }
}
