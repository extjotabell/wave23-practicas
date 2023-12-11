package com.starwars.starwars.controller;

import com.starwars.starwars.service.BuscarPersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuscarPersonajeController {

    @Autowired
    private BuscarPersonajeServiceImpl buscarPersonajeService;

    @GetMapping("/mostrarPersonaje/{nombre}")
    ResponseEntity<?> buscarPersonaje(@PathVariable String nombre) {
        return new ResponseEntity<>(buscarPersonajeService.buscar(nombre), HttpStatus.OK);
    }

    @GetMapping("/mostrarPersonajes")
    ResponseEntity<?> mostrar() {
        return new ResponseEntity<>(buscarPersonajeService.mostrar(), HttpStatus.OK);
    }

}
