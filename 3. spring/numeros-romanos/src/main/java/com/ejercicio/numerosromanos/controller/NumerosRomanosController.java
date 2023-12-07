package com.ejercicio.numerosromanos.controller;


import com.ejercicio.numerosromanos.servicio.NumerosRomanosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/numerosromanos")
public class NumerosRomanosController {

    @Autowired
    private NumerosRomanosServicio nrs;


    @GetMapping("/{numero}")
    public String obtenerNumeroRomano(@PathVariable int numero){
        return nrs.convertirANumeroRomano(numero);
    }



}
