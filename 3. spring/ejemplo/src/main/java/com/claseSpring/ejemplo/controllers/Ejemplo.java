package com.claseSpring.ejemplo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class Ejemplo {
    @GetMapping("/{nombre}")
    public String saludo(@PathVariable String nombre) {
        return "Hola, ¿Cómo estas? " + nombre;
    }
}
