package com.spring.starwars.controller;

import com.spring.starwars.service.StarWarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/StarWars")
public class StarWarsController {

    @Autowired
    private StarWarsServiceImpl _service;

    @GetMapping("/findCharacters/{characterName}")
    public ResponseEntity<?> findCharacters(@PathVariable String characterName) {
        return ResponseEntity.ok(_service.findCharacter(characterName));
    }

}
