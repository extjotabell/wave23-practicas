package com.example.ejercicio_deporte.controller;

import com.example.ejercicio_deporte.entity.Persona;
import com.example.ejercicio_deporte.service.DeporteServiceImpl;
import com.example.ejercicio_deporte.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    PersonaServiceImpl service;

    @GetMapping("/personas")
    public ResponseEntity<?> getAllPersona(){
        return new ResponseEntity<>(service.getAllPersona(), HttpStatus.OK);
    }
}
