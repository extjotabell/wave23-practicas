package com.spring.cifradoCesar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.cifradoCesar.entities.Cifrado;

@RestController
@RequestMapping("/api/cifrar")
public class CifrarController {
    @GetMapping("/{codigo}/{numero}")
    public String codifico(@PathVariable String codigo, @PathVariable String numero){
        return Cifrado.codificar(codigo.toUpperCase(),numero);
    }
}
