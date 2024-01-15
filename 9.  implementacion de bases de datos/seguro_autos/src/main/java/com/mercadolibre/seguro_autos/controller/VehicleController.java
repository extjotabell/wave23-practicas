package com.mercadolibre.seguro_autos.controller;

import com.mercadolibre.seguro_autos.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;
    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Listar las patentes de todos los vehículos registrados.
    @GetMapping("/patents")
    public ResponseEntity<?> getAllPatents() {
        return new ResponseEntity<>(vehicleService.getAllPatents(), HttpStatus.OK);
    }

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación
    @GetMapping("/patents-brand")
    public ResponseEntity<?> getPatentsAndBrand() {
        return new ResponseEntity<>(vehicleService.getPatentsAndBrand(), HttpStatus.OK);
    }

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año
    @GetMapping("/patents/filter")
    public ResponseEntity<?> getPatentsFilter() {
        return new ResponseEntity<>(vehicleService.getPatentsFilter(), HttpStatus.OK);
    }

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos
    @GetMapping("/sinister/filter")
    public ResponseEntity<?> getVehiclesWithSinisterFilter() {
        return new ResponseEntity<>(vehicleService.getVehiclesWithSinisterFilter(), HttpStatus.OK);
    }

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos
    @GetMapping("/sinister/filter/total")
    public ResponseEntity<?> getSumVehiclesWithSinisterFilter() {
        return new ResponseEntity<>(vehicleService.getSumVehiclesWithSinisterFilter(), HttpStatus.OK);
    }
}
