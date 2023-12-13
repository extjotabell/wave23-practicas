package com.meli.concesionaria.controller;

import com.meli.concesionaria.dto.VehicleDto;
import com.meli.concesionaria.service.IConcesionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcesionariaController {

    @Autowired
    private IConcesionarioService service;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody VehicleDto vehicle) {
        VehicleDto vehicleResponse = service.create(vehicle);
        return new ResponseEntity<>(vehicleResponse, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        List<VehicleDto> vehicles = service.getAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getByDate(
        @RequestParam LocalDate since,
        @RequestParam LocalDate to
    ) {
        List<VehicleDto> vehicles = service.getByDate(since, to);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getByPrice(
        @RequestParam Double since,
        @RequestParam Double to
    ) {
        List<VehicleDto> vehicles = service.getByPrice(since, to);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        VehicleDto vehicle = service.getById(id);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }
}
