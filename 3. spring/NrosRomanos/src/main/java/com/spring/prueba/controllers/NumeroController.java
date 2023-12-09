package com.spring.prueba.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NumeroController {
    @GetMapping("/{numeroAConvertir}")
    public String decimalARomano(@PathVariable int numeroAConvertir){
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String romanoReturn = "";

        for(int i = 0; i < numeros.length; i++){
            while(numeroAConvertir >= numeros[i]){
                numeroAConvertir -= numeros[i];
                romanoReturn += romanos[i];
            }
        }

        return romanoReturn;
    }
}
