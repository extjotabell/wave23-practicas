package com.codigomorse.codigomorse.controller;

import com.codigomorse.codigomorse.exceptions.MensajeInvalidoException;
import com.codigomorse.codigomorse.services.CodigoMorseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decode-morse")
public class MorseController {

    private CodigoMorseService servicio;

    public MorseController(CodigoMorseService service) {
        this.servicio = service;
    }

    @PostMapping("/decode")
    public String decodificarMensaje(@RequestBody String mensaje){
        return servicio.decodificar(mensaje);
    }

   @PostMapping("/encode")
    public ResponseEntity<String> codificarMensaje(@RequestBody String mensaje) {
        try {
            String encode = this.servicio.codificar(mensaje);
            return ResponseEntity.ok(encode);
        } catch (MensajeInvalidoException error) {
            // Loguear la excepción o manejarla de acuerdo a tus necesidades
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + error.getMessage());
        }
    }
}
