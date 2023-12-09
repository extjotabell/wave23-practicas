package com.meli.personapi.controller;

import com.meli.personapi.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/age/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        return new ResponseEntity<>(personService.calculateAge(day, month, year), HttpStatus.OK);
    }

}
