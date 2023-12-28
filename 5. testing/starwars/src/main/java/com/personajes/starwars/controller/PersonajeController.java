package com.personajes.starwars.controller;

import com.personajes.starwars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeController {
    @Autowired
    PersonajeServiceImpl service;

    @GetMapping("/findMatches/{pattern}")
    public ResponseEntity<?> obtenerMatches(@PathVariable String pattern){
        return ResponseEntity.ok().body(service.findMatches(pattern));
    }
}
