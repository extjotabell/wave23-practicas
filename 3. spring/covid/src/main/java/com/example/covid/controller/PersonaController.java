package com.example.covid.controller;

import com.example.covid.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    PersonaServiceImpl service;
    @GetMapping("/persons")
    public ResponseEntity<?> getAllPersons(){
        return new ResponseEntity<>(service.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/danger")
    public ResponseEntity<?> getDangerPerson(){
        return new ResponseEntity<>(service.getDangerPerson(), HttpStatus.OK);
    }
}
