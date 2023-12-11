package com.meli.starwars.controller;


import com.meli.starwars.dto.CharacterDTO;
import com.meli.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/starwars")
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getAllCharacters(){
        return new ResponseEntity<>(characterService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharactersFilterByName(@PathVariable String name){
        List<CharacterDTO> response = characterService.findAllFilterByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
