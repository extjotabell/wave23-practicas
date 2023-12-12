package com.example.ejercicio_cocina.controller;

import com.example.ejercicio_cocina.service.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IngredientController {

    @Autowired
    IIngredientService service;
    @GetMapping("/ingredient/{name}")
    public ResponseEntity<?> getIngredients(@PathVariable String name){
        return new ResponseEntity<>(service.getIngredient(name), HttpStatus.OK);
    }

}
