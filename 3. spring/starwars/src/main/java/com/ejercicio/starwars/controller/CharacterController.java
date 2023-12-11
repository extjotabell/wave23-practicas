package com.ejercicio.starwars.controller;


import com.ejercicio.starwars.service.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    CharacterServiceImpl service;

    @GetMapping("/getAll")
    public ResponseEntity<?> obtenerTodos(@RequestParam String query){
        return new ResponseEntity<>(service.findCharacters(query), HttpStatus.OK);
    }
}
