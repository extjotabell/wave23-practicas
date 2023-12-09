package com.meli.sports.controller;


import com.meli.sports.dto.PersonDTO;
import com.meli.sports.dto.SportDTO;
import com.meli.sports.service.PersonService;
import com.meli.sports.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sports")
public class SportsController {

    @Autowired
    SportService sportService;
    @Autowired
    PersonService personService;

    @GetMapping("/findSports")
    ResponseEntity<List<SportDTO>> getSports(){
        return new ResponseEntity<>(sportService.getSports(), HttpStatus.OK);
    }
    @GetMapping("/findSports/{name}")
    ResponseEntity<Optional<SportDTO>> getSports(@PathVariable String name){
        return new ResponseEntity<>(sportService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    ResponseEntity<List<PersonDTO>> getSportsPersons(){
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

}
