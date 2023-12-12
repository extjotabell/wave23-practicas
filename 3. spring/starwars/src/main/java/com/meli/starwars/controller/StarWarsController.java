package com.meli.starwars.controller;

import com.meli.starwars.dto.CharacterDto;
import com.meli.starwars.service.StarWarsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class StarWarsController {

    @Autowired
    private StarWarsService starWarsService;

    @GetMapping("/{query}")
    public ResponseEntity<List<CharacterDto>> getCharacters(@PathVariable String query) {
        return new ResponseEntity<>(starWarsService.findCharacters(query), HttpStatus.OK);
    }
}
