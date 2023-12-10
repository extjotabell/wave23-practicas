package com.spring.agePerson.controllers;

import com.spring.agePerson.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.agePerson.services.DateService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class DateController {
    @Autowired
    private DateService dateService;

    @GetMapping("/{day}/{month}/{year}/{name}")
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
