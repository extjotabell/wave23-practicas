package com.meli.autoinsurance.controllers;

import com.meli.autoinsurance.dtos.SiniestroDTO;
import com.meli.autoinsurance.services.SiniestroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {

    private static SiniestroService siniestroService;

    public SiniestroController(SiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiniestroDTO> getSiniestroById(@PathVariable Long id) {
        return new ResponseEntity(siniestroService.getSiniestroById(id), HttpStatus.FOUND);
    }
}
