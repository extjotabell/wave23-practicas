package com.spring.los_romanos.entities;

import java.util.*;

public class Romano {
    private HashMap<Integer, String> numeros_romanos = new HashMap<>();

    public Romano(){
        this.numeros_romanos.put(1000, "M");
        this.numeros_romanos.put(900, "CM");
        this.numeros_romanos.put(500, "D");
        this.numeros_romanos.put(400, "CD");
        this.numeros_romanos.put(100, "C");
        this.numeros_romanos.put(90, "XC");
        this.numeros_romanos.put(50, "L");
        this.numeros_romanos.put(40, "XL");
        this.numeros_romanos.put(10, "X");
        this.numeros_romanos.put(9, "IX");
        this.numeros_romanos.put(5, "V");
        this.numeros_romanos.put(4, "IV");
        this.numeros_romanos.put(1, "I");
    }

    public String convertToRomanNumber(Integer number){
        Integer decimal;
        String romanLetter;
        StringBuilder romanNumber= new StringBuilder();

        // Convert the HashMap entries to a List
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(numeros_romanos.entrySet());
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByKey()));

        for (int i = 0; i < entryList.size(); i++) {
            for (Map.Entry<Integer, String> entry : entryList) {
                decimal = entry.getKey();
                romanLetter = entry.getValue();

                if (number >= decimal) {
                    romanNumber.append(romanLetter);
                    number -= decimal;
                    break;
                }
            }
        }
        return romanNumber.toString();
    }

}
