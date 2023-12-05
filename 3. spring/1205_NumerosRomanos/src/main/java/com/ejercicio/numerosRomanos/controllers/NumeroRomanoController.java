package com.ejercicio.numerosRomanos.controllers;

import com.ejercicio.numerosRomanos.entities.NumeroRomano;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/numerosRomanos")
public class NumeroRomanoController {

    @GetMapping("/decimalAEntero/{decimal}")
    public ResponseEntity<String> convertirDecimalAEntero(@PathVariable int decimal){

        if(decimal <= 0 || decimal > 3999){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número fuera del rango permitido (entre 1 y 3999)");
        }

        NumeroRomano numeroRomano = new NumeroRomano();
        return ResponseEntity.status(HttpStatus.OK).body(numeroRomano.decimalARomano(decimal));
    }

}
