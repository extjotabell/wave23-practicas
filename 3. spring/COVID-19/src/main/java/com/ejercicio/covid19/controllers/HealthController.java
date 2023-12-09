package com.ejercicio.covid19.controllers;

import com.ejercicio.covid19.dto.response.RiskPersonDto;
import com.ejercicio.covid19.dto.response.SyntomDto;
import com.ejercicio.covid19.entities.Syntom;
import com.ejercicio.covid19.exceptions.NotRiskPersonsOnSistem;
import com.ejercicio.covid19.exceptions.NotSyntomFindedWithName;
import com.ejercicio.covid19.exceptions.NotSyntomsOnSistem;
import com.ejercicio.covid19.services.IHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("api/healt")
public class HealthController {

    @Autowired
    IHealthService healthService;

    @GetMapping("/findSymptom")
    public ResponseEntity<?> findAllSymptom() {
        try {
            Set<Syntom> syntoms = healthService.getSyntoms();
            return ResponseEntity.ok(syntoms);
        } catch (NotSyntomsOnSistem ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptom(@PathVariable String name) {
        try {
            SyntomDto syntom = healthService.findSympton(name);
            return ResponseEntity.ok(syntom);
        } catch (NotSyntomFindedWithName ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findRiskPersons() {
        try {
            Set<RiskPersonDto> riskPersons = healthService.getRiskPersons();
            return ResponseEntity.ok(riskPersons);
        } catch (NotRiskPersonsOnSistem ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
