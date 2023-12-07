package com.bootcamp.apiCalcularEdad.controller;

import com.bootcamp.apiCalcularEdad.entities.Persona;
import com.bootcamp.apiCalcularEdad.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/persona")
public class AgeController {
    @Autowired
    private AgeService ageService;

    @GetMapping()
    ResponseEntity<List<Persona>> getAll(){
        return new ResponseEntity<>(ageService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/age/{day}/{month}/{year}")
    ResponseEntity<Persona> setAge(@PathVariable int day, @PathVariable int month, @PathVariable int year, @RequestBody Persona p){
        ageService.setAge(day,month,year,p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Persona> save(@RequestBody Persona p){
        ageService.save(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
