package com.meli.autoinsurance.controllers;

import com.meli.autoinsurance.dtos.VehiculoDTO;
import com.meli.autoinsurance.services.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> getVehiculoById(@PathVariable Long id) {
        return new ResponseEntity<VehiculoDTO>(vehiculoService.getVehiculoById(id), HttpStatus.FOUND);
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getPatentes() {
        return new ResponseEntity<List<String>>(vehiculoService.getPatentes(), HttpStatus.FOUND);
    }

}
