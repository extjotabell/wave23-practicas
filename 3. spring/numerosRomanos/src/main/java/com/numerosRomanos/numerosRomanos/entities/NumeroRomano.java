package com.numerosRomanos.numerosRomanos.entities;
import java.util.TreeMap;
import java.util.Map;

public class NumeroRomano {
    private static final TreeMap<Integer, String> romanNumerals = new TreeMap<>();
    private static final TreeMap<String, Integer> reverseRomanNumerals = new TreeMap<>();

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

    public static String numeroARomano(int num) {
        int floorValue = romanNumerals.floorKey(num);
        if (num == floorValue) {
            return romanNumerals.get(num);
        }
        return romanNumerals.get(floorValue) + numeroARomano(num - floorValue);
    }

    public static String romanoANumero(String roman) {
        //mapa inverso
        for (Map.Entry<Integer, String> entry : romanNumerals.entrySet()) {
            reverseRomanNumerals.put(entry.getValue(), entry.getKey());
        }
        int result = 0;
        for (Map.Entry<String, Integer> entry : reverseRomanNumerals.descendingMap().entrySet()) {
            while (roman.startsWith(entry.getKey())) {
                result += entry.getValue();
                roman = roman.substring(entry.getKey().length());
            }
        }
        return String.valueOf(result);
    }
}
