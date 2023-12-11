package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.PersonDTO;
import com.bootcamp.covid.dto.SymptomDTO;
import com.bootcamp.covid.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/covid")
public class CovidController {
    private CovidService service;

    @Autowired
    public CovidController(CovidService covidService){
        this.service = covidService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findAllSymptom(){
            return new ResponseEntity<>(service.findAllSymptom(), HttpStatus.OK);
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable String name){
        if(service.findSymptomByName(name) == null){
            return new ResponseEntity<>(service.findSymptomByName(name), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.findSymptomByName(name), HttpStatus.OK);
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDTO>> findAllRiskPerson(){
        if(service.findAllRiskPerson() == null){
            return new ResponseEntity<>(service.findAllRiskPerson(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.findAllRiskPerson(), HttpStatus.OK);
    }

}
