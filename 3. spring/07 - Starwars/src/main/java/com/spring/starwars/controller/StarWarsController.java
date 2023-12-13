package com.spring.starwars.controller;

import com.spring.starwars.service.StarWarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarWarsController {

    private StarWarsServiceImpl StarWarsService;

    @Autowired
    public StarWarsController(StarWarsServiceImpl starWarsService) {
        StarWarsService = starWarsService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> obtenerTodos(){
        return new ResponseEntity<>(StarWarsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> obtenerPorNombre(@RequestParam String name){
        return new ResponseEntity<>(StarWarsService.findByName(name), HttpStatus.OK);
    }
}
