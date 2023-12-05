package com.example.numerosRomanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NumerosRomanosController {

    @GetMapping("/{numero}")
    public String toRoman(@PathVariable Integer numero) {

        StringBuilder resultado = new StringBuilder();

        int[] numerosComparar = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int x = 0; x < numerosComparar.length; x++) {
            while (numero >= numerosComparar[x]) {
                numero = numero - numerosComparar[x];
                resultado.append(numerosRomanos[x]);
            }
        }
        return resultado.toString();

    }
}
