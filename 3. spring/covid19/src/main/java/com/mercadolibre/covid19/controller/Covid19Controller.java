package com.mercadolibre.covid19.controller;

import com.mercadolibre.covid19.service.Covid19ServiceImpl;
import com.mercadolibre.covid19.service.ICovid19Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Covid19Controller {
    ICovid19Service service;

    public Covid19Controller(Covid19ServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> findAllSymptoms() {
        return new ResponseEntity<>(service.findAllSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findAllSymptoms(@PathVariable String name) {
        return new ResponseEntity<>(service.findSymptomByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findRiskperson() {
        return new ResponseEntity<>(service.findRiskPerson(), HttpStatus.OK);
    }
}
