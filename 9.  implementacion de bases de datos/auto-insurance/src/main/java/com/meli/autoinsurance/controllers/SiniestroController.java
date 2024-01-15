package com.meli.autoinsurance.controllers;

import com.meli.autoinsurance.dtos.response.MatriculaMarcaModeloDTO;
import com.meli.autoinsurance.dtos.request.SiniestroDTO;
import com.meli.autoinsurance.dtos.response.SiniestroResponseDTO;
import com.meli.autoinsurance.services.SiniestroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {

    private static SiniestroService siniestroService;

    public SiniestroController(SiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiniestroResponseDTO> getSiniestroById(@PathVariable Long id) {
        return new ResponseEntity(siniestroService.getSiniestroById(id), HttpStatus.FOUND);
    }

    @GetMapping("perdida-mayor-10k")
    public ResponseEntity<List<MatriculaMarcaModeloDTO>> getMatriculaMarcaModeloByPerdidaGreaterThan10K(){
        return new ResponseEntity(siniestroService.getMatriculaMarcaModeloByPerdidaGreaterThan10K(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SiniestroDTO> createSiniestro(@RequestBody SiniestroDTO siniestroDTO) {
        return new ResponseEntity(siniestroService.createSiniestro(siniestroDTO), HttpStatus.CREATED);
    }
}
