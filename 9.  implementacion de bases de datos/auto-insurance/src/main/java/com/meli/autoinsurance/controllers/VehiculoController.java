package com.meli.autoinsurance.controllers;

import com.meli.autoinsurance.dtos.response.PatenteMarcaDTO;
import com.meli.autoinsurance.dtos.response.VehiculoDTO;
import com.meli.autoinsurance.services.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<List<String>>(vehiculoService.getPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patentes-marcas")
    public ResponseEntity<List<PatenteMarcaDTO>> getPatenteMarca() {
        return new ResponseEntity<List<PatenteMarcaDTO>>(vehiculoService.getPatenteMarca(), HttpStatus.OK);
    }

    @GetMapping("/patentes-ruedas-anio-actual")
    public ResponseEntity<List<String>> getVehiculoFilterCuatroRuedasAnioActual() {
        return new ResponseEntity<List<String>>(vehiculoService.getVehiculoFilterCuatroRuedasAnioActual(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehiculoDTO> createVehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
        return new ResponseEntity<VehiculoDTO>(vehiculoService.createVehiculo(vehiculoDTO), HttpStatus.CREATED);
    }
}
