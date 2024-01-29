package com.example.NumerosRomanos.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
@RequestMapping("/api/romano")
public class RomanoControlador {

    private final static TreeMap<Integer, String> numerosRomanosMap = new TreeMap<>();

    static {
        numerosRomanosMap.put(1, "I");
        numerosRomanosMap.put(4, "IV");
        numerosRomanosMap.put(5, "V");
        numerosRomanosMap.put(9, "IX");
        numerosRomanosMap.put(10, "X");
        numerosRomanosMap.put(40, "XL");
        numerosRomanosMap.put(50, "L");
        numerosRomanosMap.put(90, "XC");
        numerosRomanosMap.put(100, "C");
        numerosRomanosMap.put(400, "CD");
        numerosRomanosMap.put(500, "D");
        numerosRomanosMap.put(900, "CM");
        numerosRomanosMap.put(1000, "M");
    }

    @GetMapping("/convertir/{decimal}")
    public String convertir(@PathVariable Integer decimal) {
        int decimalCercano = numerosRomanosMap.floorKey(decimal);
        if (decimal == decimalCercano) {
            return numerosRomanosMap.get(decimal);
        }
        return numerosRomanosMap.get(decimalCercano) + convertir(decimal - decimalCercano);
    }


}