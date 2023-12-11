package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.entity.Personaje;
import com.bootcamp.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/personajes")
public class PersonajeRestController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/getPersonajeByName/{name}")
    public ResponseEntity<?> getPersonajeByName(@PathVariable String name){
        return new ResponseEntity<>(personajeService.getPersonajesByName(name), HttpStatus.OK);
    }

    @GetMapping("/getPersonaje")
    public ResponseEntity<?> getAllPersonajes(){
        return new ResponseEntity<>(personajeService.getAllPersonajes(), HttpStatus.OK);
    }

}
