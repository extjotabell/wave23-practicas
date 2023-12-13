package org.meli.controller;

import org.meli.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personajesAPI")
public class PersonajeController {
    @Autowired
    private PersonajeService service;

    @GetMapping("/getPersonajes")
    public ResponseEntity<?> getAllPersonaje(){
        return new ResponseEntity<>(service.getAllPersonajes(), HttpStatus.OK);
    }

    @GetMapping("/getPersonajes/{name}")
    public ResponseEntity<?> getPersonajeByName(@PathVariable String name){
        return new ResponseEntity<>(service.getPersonajeByName(name), HttpStatus.OK);
    }
}
