package com.mercadolibre.deportistas.controller;

import com.mercadolibre.deportistas.dto.PersonDTO;
import com.mercadolibre.deportistas.dto.SportDTO;
import com.mercadolibre.deportistas.service.DeportistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {

    @Autowired
    DeportistaServiceImpl service;

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> findSports() {
        return new ResponseEntity<>(this.service.findSports(),HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<List<String>> findSport(@PathVariable String name){
        return new ResponseEntity<>(this.service.findSport(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> findSportsPersons(){
        return new ResponseEntity<>(this.service.findSportsPersons(), HttpStatus.OK);
    }
}
