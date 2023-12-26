package com.mercadolibre.romannumerals.utils;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralTestCases {
    public static Map<Integer, String> testCases = new HashMap<>();

    static {
        testCases.put(3999, "MMMCMXCIX");
        testCases.put(3000, "MMM");
        testCases.put(2023, "MMXXIII");
        testCases.put(1000, "M");
        testCases.put(900, "CM");
        testCases.put(876, "DCCCLXXVI");
        testCases.put(500, "D");
        testCases.put(400, "CD");
        testCases.put(100, "C");
        testCases.put(90, "XC");
        testCases.put(50, "L");
        testCases.put(40, "XL");
        testCases.put(34, "XXXIV");
        testCases.put(10, "X");
        testCases.put(9, "IX");
        testCases.put(7, "VII");
        testCases.put(5, "V");
        testCases.put(4, "IV");
        testCases.put(3, "III");
        testCases.put(1, "I");
    }
}
