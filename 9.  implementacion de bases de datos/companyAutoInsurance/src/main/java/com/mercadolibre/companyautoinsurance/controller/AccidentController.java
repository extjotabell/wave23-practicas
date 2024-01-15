package com.mercadolibre.companyautoinsurance.controller;

import com.mercadolibre.companyautoinsurance.models.dtos.AccidentDTO;
import com.mercadolibre.companyautoinsurance.services.IAccidentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccidentController {

    private final IAccidentService accidentService;

    public AccidentController(IAccidentService accidentService) {
        this.accidentService = accidentService;
    }

    /**
     * Save a new accident
     *
     */
    @PostMapping("/saveAccident")
    public ResponseEntity<AccidentDTO> saveAccident(@RequestBody AccidentDTO accidentDTO){
        return new ResponseEntity<>(accidentService.saveAccident(accidentDTO), HttpStatus.OK);
    }
}
