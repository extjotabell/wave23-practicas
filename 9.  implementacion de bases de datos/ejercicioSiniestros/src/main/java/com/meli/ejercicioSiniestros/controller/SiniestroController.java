package com.meli.ejercicioSiniestros.controller;

import com.meli.ejercicioSiniestros.dto.request.SiniestroCreationDTO;
import com.meli.ejercicioSiniestros.service.SiniestroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {
    private final SiniestroService service;

    public SiniestroController(SiniestroService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<?> createSiniestro(@RequestBody SiniestroCreationDTO siniestroDto){
        return new ResponseEntity<>(service.createSiniestro(siniestroDto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllSiniestros(){
        return new ResponseEntity<>(service.getAllSiniestros(), HttpStatus.OK);
    }
}
