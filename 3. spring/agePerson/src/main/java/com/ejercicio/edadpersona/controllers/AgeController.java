package com.ejercicio.edadpersona.controllers;

import com.ejercicio.edadpersona.entities.Person;
import com.ejercicio.edadpersona.entities.PersonDTO;
import com.ejercicio.edadpersona.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/edad")
public class AgeController {

    @Autowired
    AgeService ageService;

    @PostMapping
    public ResponseEntity<?> returnAge(@RequestBody Person person) {
        try {
            Integer age = ageService.execute(person.getDay(), person.getMonth(), person.getYear());
            return ResponseEntity.ok(new PersonDTO(person.getName() + " " + person.getSurname(), age));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
