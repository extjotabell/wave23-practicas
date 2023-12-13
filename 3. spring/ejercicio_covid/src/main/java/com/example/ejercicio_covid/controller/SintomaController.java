package com.example.ejercicio_covid.controller;


import com.example.ejercicio_covid.service.SintomaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;

@RestController
@RequestMapping("/api")
public class SintomaController {
    @Autowired
    SintomaServiceImpl service;

    @GetMapping("/sintomas")
    public ResponseEntity<?> getAllSintoms(){
        return new ResponseEntity<>(service.getAllSintomas(), HttpStatus.OK);
    }

    @GetMapping("/sintomas/{name}")
    public ResponseEntity<?> getSintom(@PathVariable String name){
        return new ResponseEntity<>(service.getSintom(name), HttpStatus.OK);
    }
}
