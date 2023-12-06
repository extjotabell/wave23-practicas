package com.spring.numerosRomanos.controllers;

import com.spring.numerosRomanos.entities.RomanNumber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/roman")
public class RomanNumberController {
    @GetMapping("/{numero}")
    public String obtenerNumeroRomano(@PathVariable int numero){
        return RomanNumber.integerToRoman(numero);
    }
}