package com.spring.demo.controllers;

import com.spring.demo.services.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConversorController {

    private final ConversorService conversorService;

    @Autowired
    public ConversorController(ConversorService conversorService) {
        this.conversorService = conversorService;
    }


    @GetMapping("/romanConversor")
    public String convertirNumero(@RequestParam int numeroDecimal){
        String numeroRomano = conversorService.convertirDeDecimalARomano(numeroDecimal);
        return numeroRomano;
    }

}
