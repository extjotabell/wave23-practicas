package com.claseUno.ejemplo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Ejemplo {

    @GetMapping("/{nombre}")
    public String saldo(@PathVariable String nombre) {
        return "Hola, como estás? " + nombre;
    }
}
