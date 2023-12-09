package com.meli.personapi.controller;

import com.meli.personapi.dto.request.PersonDTO;
import com.meli.personapi.dto.response.PersonResponseDTO;
import com.meli.personapi.exception.PERSONEXCEPTION;
import com.meli.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/age/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) throws PERSONEXCEPTION {
        return new ResponseEntity<>(personService.calculateAge(day, month, year), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<PersonResponseDTO>> addPerson(@RequestBody PersonDTO person) throws PERSONEXCEPTION {
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }

}
