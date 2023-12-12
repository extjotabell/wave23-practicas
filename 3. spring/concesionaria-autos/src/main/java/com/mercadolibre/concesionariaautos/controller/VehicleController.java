package com.mercadolibre.concesionariaautos.controller;

import com.mercadolibre.concesionariaautos.dto.VehicleDto;
import com.mercadolibre.concesionariaautos.repository.VehicleRepositoryImpl;
import com.mercadolibre.concesionariaautos.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {
    @Autowired
    VehicleServiceImpl service;
    @Autowired
    VehicleRepositoryImpl repository;

    @PostMapping
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDto vehicle) {
        try {
            service.save(vehicle);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(repository.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/dates")
    public ResponseEntity<?> filterVehiclesByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date since,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        try {
            return new ResponseEntity<>(service.filterByDate(since, to), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/prices")
    public ResponseEntity<?> filterVehiclesByPrice(@RequestParam Double since, @RequestParam Double to) {
        try {
            return new ResponseEntity<>(service.filterByPrice(since, to), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
