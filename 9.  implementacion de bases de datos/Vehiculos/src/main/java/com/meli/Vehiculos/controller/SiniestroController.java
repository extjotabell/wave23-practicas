package com.meli.Vehiculos.controller;

import com.meli.Vehiculos.dto.response.SiniestroResponseDTO;
import com.meli.Vehiculos.dto.request.SiniestroRequestDTO;
import com.meli.Vehiculos.service.ISiniestroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {

    ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody SiniestroRequestDTO siniestroDTO) {
        SiniestroResponseDTO response = siniestroService.save(siniestroDTO);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<SiniestroResponseDTO> response = siniestroService.findAll();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        SiniestroResponseDTO response = siniestroService.findById(id);
        return ResponseEntity.status(200).body(response);
    }

}
