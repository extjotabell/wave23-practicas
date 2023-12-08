package com.example.covid.controllers;

import com.example.covid.dto.PersonasRiesgoDTO;
import com.example.covid.dto.SymptomDTO;
import com.example.covid.dto.SymptomListDTO;
import com.example.covid.services.CovidServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CovidController {

    private CovidServices covidServices;

    public CovidController(CovidServices covidServices) {
        this.covidServices = covidServices;
    }

    @GetMapping("/findSymptoms")
    public ResponseEntity<SymptomListDTO> findSymptoms() {
        return ResponseEntity.ok(covidServices.findSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptom(@PathVariable String name) {
        Optional<SymptomDTO> symptomDTO = covidServices.findSymptom(name);
        return symptomDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findRiskPersons")
    public ResponseEntity<PersonasRiesgoDTO> findRiskPersons() {
        return ResponseEntity.ok(covidServices.findRiskPersons());
    }
}
