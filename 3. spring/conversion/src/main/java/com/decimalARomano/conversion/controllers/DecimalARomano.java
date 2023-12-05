package com.decimalARomano.conversion.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/convertir")
public class DecimalARomano {

    @GetMapping("/{nroDecimal}")
    public String convertirDecimalARomano(@PathVariable int nroDecimal) {
        int nroDecimalAux = nroDecimal;
        StringBuilder resultado = new StringBuilder();

        String[] simbolosRomanos = {
                "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"
        };
        int[] valoresRomanos = {
                1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000
        };

        int indice = 12;

        while (nroDecimalAux > 0) {
            int divisor = nroDecimalAux / valoresRomanos[indice];
            nroDecimalAux %= valoresRomanos[indice];

            while (divisor > 0) {
                resultado.append(simbolosRomanos[indice]);
                divisor--;
            }

            indice--;
        }

        return "El número decimal " + nroDecimal + ", en romano es: " + resultado.toString();
    }

}
