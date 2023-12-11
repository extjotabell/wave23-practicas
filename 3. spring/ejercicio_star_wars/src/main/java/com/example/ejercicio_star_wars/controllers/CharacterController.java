package com.example.ejercicio_star_wars.controllers;


import com.example.ejercicio_star_wars.services.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {


    @Autowired
    CharacterServiceImpl service;
    @GetMapping("/getCharacters/{variable}")
    public ResponseEntity<?> obtenerTodos(@PathVariable String variable) throws Exception {
        return new ResponseEntity<>(service.findCharacter(variable), HttpStatus.OK);
    }
}
