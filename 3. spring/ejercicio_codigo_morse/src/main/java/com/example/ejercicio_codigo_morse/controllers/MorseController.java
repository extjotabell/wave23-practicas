package com.example.ejercicio_codigo_morse.controllers;

import com.example.ejercicio_codigo_morse.entities.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/morse")
public class MorseController {
    @GetMapping("/{code}")
    public String obtenerPalabra(@PathVariable String code){
        return Morse.translateToSpanish(code);
    }
}
