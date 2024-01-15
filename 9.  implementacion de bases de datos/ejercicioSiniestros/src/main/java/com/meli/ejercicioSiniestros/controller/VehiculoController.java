package com.meli.ejercicioSiniestros.controller;

import com.meli.ejercicioSiniestros.dto.request.VehiculoCreationDTO;
import com.meli.ejercicioSiniestros.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<?> createVehiculo(@RequestBody VehiculoCreationDTO vehiculoDto){
        return new ResponseEntity<>(service.createVehiculo(vehiculoDto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllVehiculos(){
        return new ResponseEntity<>(service.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> getAllPatentes(){
        return new ResponseEntity<>(service.getAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patente-marca")
    public ResponseEntity<?> getPatenteYMarcaFromVehiculo(){
        return new ResponseEntity<>(service.getPatenteYMarcaFromVehiculo(), HttpStatus.OK);
    }

    @GetMapping("/mas-ruedas/4/ano-fabricacion/actual")
    public ResponseEntity<?> getAllVehiculosWithMoreThanFourWheelsAndFabricatedThisYear(){
        return new ResponseEntity<>(service.getAllVehiculosWithMoreThanFourWheelsAndFabricatedThisYear(), HttpStatus.OK);
    }

    @GetMapping("/siniestros/mas-costo/10000")
    public ResponseEntity<?> getVehiculosWithSiniestroCostingMoreThanTenThousand(){
        return new ResponseEntity<>(service.getVehiculosWithSiniestroCostingMoreThanTenThousand(), HttpStatus.OK);
    }
}
