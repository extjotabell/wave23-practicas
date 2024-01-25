package com.bootcampmeli.personajesStarWars.controller;

import com.bootcampmeli.personajesStarWars.dto.PersonajeDTO;
import com.bootcampmeli.personajesStarWars.repository.PersonajeRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/StarWars")
public class PersonajeController {
    PersonajeRepositoryImpl repository = new PersonajeRepositoryImpl();

    @GetMapping("/{query}")
    public ResponseEntity<?> buscarPersonaje(@PathVariable String query){
        return new ResponseEntity<>(repository.buscarPersonajePorNombre(query), HttpStatus.OK);
    }
}
