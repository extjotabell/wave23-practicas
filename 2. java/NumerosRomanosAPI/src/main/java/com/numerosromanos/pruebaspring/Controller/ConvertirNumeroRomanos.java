package com.numerosromanos.pruebaspring.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ConvertirNumeroRomanos {

    public static Map<String, Integer> romanos = new TreeMap<>(((o1, o2) -> -o1.compareTo(o2)));

    public String convertirDecimalNumerosRomano(double numeroDecimal){
        String numeroRomano = "";
        numerosRomano();
        while(numeroDecimal >= 1){
            for (Map.Entry<String, Integer> romano: romanos.entrySet()) {
                if(romano.getValue() <= numeroDecimal){
                    numeroDecimal = numeroDecimal - romano.getValue();
                    numeroRomano += romano.getKey();
                    break;
                }
            }
        }


        return numeroRomano;
    }

    public void numerosRomano(){
        romanos.put("M", 1000);
        romanos.put("CM", 900);
        romanos.put("D", 500);
        romanos.put("CD", 400);
        romanos.put("C", 100);
        romanos.put("XC", 90);
        romanos.put("L", 50);
        romanos.put("XL", 40);
        romanos.put("X", 10);
        romanos.put("IX", 9);
        romanos.put("V", 5);
        romanos.put("IV", 4);
        romanos.put("I", 1);
    }

}
