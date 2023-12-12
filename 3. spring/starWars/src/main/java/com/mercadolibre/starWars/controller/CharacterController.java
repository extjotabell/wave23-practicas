package com.mercadolibre.starWars.controller;

import com.mercadolibre.starWars.dto.CharacterDto;
import com.mercadolibre.starWars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/starwars")
public class CharacterController {



    @Autowired
    ICharacterService service;

    @GetMapping("/getAllCharacters")
    public ResponseEntity<?> getAllPersonaje(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getCharacters/{name}")
    public ResponseEntity<?> getPersonajeByName(@PathVariable String name){
        return new ResponseEntity<>(service.getCharacterByName(name), HttpStatus.OK);
    }
}
