package com.NumerosRomanos.conversioDecimalAEnteros.controllers;

import com.NumerosRomanos.conversioDecimalAEnteros.entities.Roman;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roman")
public class RomanController {
    @GetMapping("/{numero}")
    public String obtenerNumeroRomano(@PathVariable int numero){
        return Roman.integerToRoman(numero);
    }
}
