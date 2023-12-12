package com.starwars.practice.controller;

import com.starwars.practice.dto.CharactersDTO;
import com.starwars.practice.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharactersController {
    @Autowired
    ICharacterService ics;

    @GetMapping (path = "/findCharacters/{name}")
    ResponseEntity<CharactersDTO> findCharacters (@PathVariable String name) {
        return ResponseEntity.ok(ics.getCharacters(name));
    }
}
