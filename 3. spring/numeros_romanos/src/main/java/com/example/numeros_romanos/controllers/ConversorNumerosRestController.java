package com.example.numeros_romanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConversorNumerosRestController {

    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable int numero) {
        int[] valoresNumericos = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] valoresRomanos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        StringBuilder res = new StringBuilder();

        for (int i = valoresNumericos.length - 1; i >= 0; i --) {
            while (numero >= valoresNumericos[i]) {
                numero -= valoresNumericos[i];
                res.append(valoresRomanos[i]);
            }
        }

        return res.toString();
    }

}
