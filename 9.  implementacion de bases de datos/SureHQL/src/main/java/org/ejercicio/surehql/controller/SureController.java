package org.ejercicio.surehql.controller;

import org.ejercicio.surehql.service.ISureService;
import org.ejercicio.surehql.service.SureServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sure")
public class SureController {

    private final ISureService service;

    public SureController(SureServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/patents")
    public ResponseEntity<?> getPatents() {
        return new ResponseEntity<>(service.getPatents(), HttpStatus.OK);
    }

    @GetMapping("/patents-brand")
    public ResponseEntity<?> getPatentsAndBrand() {
        return new ResponseEntity<>(service.getPatentsAndBrand(), HttpStatus.OK);
    }

    @GetMapping("/patents/filter")
    public ResponseEntity<?> getPatentsFilter() {
        return new ResponseEntity<>(service.getPatentsFilter(), HttpStatus.OK);
    }

    @GetMapping("/sinister-filter")
    public ResponseEntity<?> getModelFilteredSinister(){
        return new ResponseEntity<>(service.getModelFilteredSinister(), HttpStatus.OK);
    }

    @GetMapping("/sinister-sum")
    public ResponseEntity<?> getModelFilteredSinisterSum(){
        return new ResponseEntity<>(service.getModelFilteredSinisterSum(), HttpStatus.OK);
    }
}
