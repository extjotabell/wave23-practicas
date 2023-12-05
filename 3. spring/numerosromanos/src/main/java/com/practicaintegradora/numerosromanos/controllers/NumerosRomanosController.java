package com.practicaintegradora.numerosromanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/NumerosRomanos")
public class NumerosRomanosController {

    @GetMapping("/decimalToNroRomano/{numero}")
    public String decimalToNroRomano(@PathVariable int numero) {
        return convertDecimalToRomano(numero);
    }

    private String convertDecimalToRomano(int numero) {
        List<Integer> decimales = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        List<String> simbolosRomanos = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

        StringBuilder res = new StringBuilder();
        int i = 0;

        while (numero > 0) {
            if (numero >= decimales.get(i)) {
                res.append(simbolosRomanos.get(i));
                numero -= decimales.get(i);
            } else {
                i++;
            }
        }

        return res.toString();
    }
}
