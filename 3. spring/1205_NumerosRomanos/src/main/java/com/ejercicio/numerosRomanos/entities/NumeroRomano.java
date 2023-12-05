package com.ejercicio.numerosRomanos.entities;

import java.util.HashMap;

public class NumeroRomano {

    private HashMap<Integer, String> decimalRomanos;
    private String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private int[] decimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public NumeroRomano(){
        decimalRomanos = new HashMap<Integer, String>();
        decimalRomanos.put(1, "I");
        decimalRomanos.put(4, "IV");
        decimalRomanos.put(5, "V");
        decimalRomanos.put(9, "IX");
        decimalRomanos.put(10, "X");
        decimalRomanos.put(40, "XL");
        decimalRomanos.put(50, "L");
        decimalRomanos.put(90, "XC");
        decimalRomanos.put(100, "C");
        decimalRomanos.put(400, "CD");
        decimalRomanos.put(500, "D");
        decimalRomanos.put(900, "CM");
        decimalRomanos.put(1000, "M");
    }

    public String decimalARomano(Integer decimal){
        String romano = "";
        int auxiliarDecimal = decimal;

        for(int i = 0; i < this.decimales.length; i++){
            while(auxiliarDecimal >= this.decimales[i]){
                auxiliarDecimal -= this.decimales[i];
                romano += this.romanos[i];
            }
        }

        return romano;
    }

}
