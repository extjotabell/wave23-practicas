package com.spring.starwars.controllers;

import com.spring.starwars.dtos.PersonajeDto;
import com.spring.starwars.services.IPersonajeService;
import com.spring.starwars.services.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starwars-api")
public class PersonajeController {

    @Autowired
    private IPersonajeService personajeService;

    @GetMapping("/personajes")
    public List<PersonajeDto> findAll() {
        return personajeService.findAll();
    }

    @GetMapping("/personajes/search/{name}")
    public List<PersonajeDto> searchByName (@PathVariable String name) {
        return personajeService.searchByName(name.toLowerCase());
    }
}
