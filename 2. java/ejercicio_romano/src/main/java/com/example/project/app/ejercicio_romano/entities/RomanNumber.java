package com.example.project.app.ejercicio_romano.entities;

import java.util.TreeMap;

public class RomanNumber {
    private static final TreeMap<Integer, String> romanNumerals = new TreeMap<>();

    static {
        romanNumerals.put(1, "I");
        romanNumerals.put(4, "IV");
        romanNumerals.put(5, "V");
        romanNumerals.put(9, "IX");
        romanNumerals.put(10, "X");
        romanNumerals.put(40, "XL");
        romanNumerals.put(50, "L");
        romanNumerals.put(90, "XC");
        romanNumerals.put(100, "C");
        romanNumerals.put(400, "CD");
        romanNumerals.put(500, "D");
        romanNumerals.put(900, "CM");
        romanNumerals.put(1000, "M");
    }

    public static String integerToRoman(int num) {
        int floorValue = romanNumerals.floorKey(num);
        if (num == floorValue) {
            return romanNumerals.get(num);
        }
        return romanNumerals.get(floorValue) + integerToRoman(num - floorValue);
    }
}
