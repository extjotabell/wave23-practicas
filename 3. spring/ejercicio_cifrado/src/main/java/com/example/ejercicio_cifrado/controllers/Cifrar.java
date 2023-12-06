package com.example.ejercicio_cifrado.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ejercicio_cifrado.entities.Cifrado;

@RestController
@RequestMapping("/api/cifrar")
public class Cifrar {
    @GetMapping("/{codigo}/{numero}")
    public String codifico(@PathVariable String codigo, @PathVariable String numero){
        return Cifrado.codificar(codigo.toUpperCase(),numero);
    }
}
