package com.example.ejercicio_deporte.controller;

import com.example.ejercicio_deporte.service.DeporteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeporteController {
    @Autowired
    DeporteServiceImpl service;

    @GetMapping("/deportes")
    public ResponseEntity<?> getAllDeporte(){
        return new ResponseEntity<>(service.getAllDeporte(), HttpStatus.OK);
    }

    @GetMapping("/deportes/{name}")
    public ResponseEntity<?> getDeporte(@PathVariable String name){
        return new ResponseEntity<>(service.getDeporte(name), HttpStatus.OK);
    }
}
