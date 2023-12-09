package com.meli.healthapi.controller;

import com.meli.healthapi.dto.PersonDTO;
import com.meli.healthapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons(){
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }


    @PostMapping("/load")
    public ResponseEntity<List<PersonDTO>> loadPersons(@RequestBody List<PersonDTO> listNewPersons){
        for (PersonDTO p : listNewPersons) personService.addPerson(p);
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }
}
