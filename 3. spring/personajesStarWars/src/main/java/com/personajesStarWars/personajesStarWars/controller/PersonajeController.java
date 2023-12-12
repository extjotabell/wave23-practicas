package com.personajesStarWars.personajesStarWars.controller;

import com.personajesStarWars.personajesStarWars.dto.PersonajeDto;
import com.personajesStarWars.personajesStarWars.service.IPersonajeService;
import com.personajesStarWars.personajesStarWars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeServiceImpl service;

    @GetMapping("/personajes")
    public ResponseEntity<?> getAllPersonajes(){
        List<PersonajeDto> personajeDTOList = service.getAll();
        return new ResponseEntity<>(personajeDTOList, HttpStatus.OK);
    }

    @GetMapping("/personajes/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<>(service.findByName(name),HttpStatus.OK);
    }
}
