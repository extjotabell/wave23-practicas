package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.service.StarwarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starwars")
public class StarwarsController {
    @Autowired
    StarwarsServiceImpl service;

    @GetMapping("/character/{name}")
    public ResponseEntity<?> findCharacter(@PathVariable String name) {
        try {
            return new ResponseEntity<>(service.findCharacterByName(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
