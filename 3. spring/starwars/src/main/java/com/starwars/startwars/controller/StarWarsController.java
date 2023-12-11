package com.starwars.startwars.controller;

import com.starwars.startwars.dto.PersonajesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.starwars.startwars.service.StarWarsServiceImp;

@RestController
public class StarWarsController {

    @Autowired
    private StarWarsServiceImp starWarsServiceImp;

    @GetMapping("/personajes/{nombre}")
    public ResponseEntity<PersonajesDTO> buscarPersonaje(@PathVariable String nombre) {
        return ResponseEntity.ok(starWarsServiceImp.find(nombre));
    }

}
