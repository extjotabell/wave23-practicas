package com.birthdate.birthdate.controllers;

import ch.qos.logback.core.joran.sanity.Pair;
import com.birthdate.birthdate.entity.Person;
import com.birthdate.birthdate.services.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.util.*;

@RestController
@RequestMapping("/")
public class DateController {
    @Autowired
    private DateService dateService;

    @GetMapping("/{day} /{month}/{year}/{name}")
    public Person getPersonAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year, @PathVariable String name){
        return this.dateService.createPerson(day, month, year,name);
    }

    @GetMapping("/{day}/{month}/{year}/{name}/json")
    public Map<String,String> getPersonPear(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year, @PathVariable String name){
        Person person =  this.dateService.createPerson(day, month, year,name);
        Map<String,String> datos = new HashMap<>();
        datos.put("Nombre", person.getNombre());
        datos.put("Edad",person.getAge().toString());
        return datos;
    }

}
