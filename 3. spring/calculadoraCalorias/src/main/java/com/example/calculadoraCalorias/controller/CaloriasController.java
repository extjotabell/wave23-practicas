package com.example.calculadoraCalorias.controller;


import com.example.calculadoraCalorias.service.CaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/calorias")
public class CaloriasController{

    @Autowired
    CaloriasService service;


    @GetMapping("{plato}")
    public ResponseEntity<?> obtenerPlato(@PathVariable String plato) {
        return new ResponseEntity<>(service.getCalorias(plato), HttpStatus.OK);
    }
}
