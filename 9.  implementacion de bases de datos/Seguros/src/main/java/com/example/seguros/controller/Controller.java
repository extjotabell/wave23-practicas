package com.example.seguros.controller;

import com.example.seguros.dto.AccidentRequestDTO;
import com.example.seguros.dto.VehicleRequestDTO;
import com.example.seguros.service.accident.AccidentService;
import com.example.seguros.service.vehicle.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final VehicleService vehicleService;
    private final AccidentService accidentService;

    public Controller(VehicleService vehicleService, AccidentService accidentService) {
        this.vehicleService = vehicleService;
        this.accidentService = accidentService;
    }

    @PostMapping("/accident")
    public ResponseEntity<?> postAccident(@RequestBody AccidentRequestDTO accidentRequestDTO) {
        accidentService.postAccident(accidentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/vehicle")
    public ResponseEntity<?> postVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        vehicleService.postVehicle(vehicleRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/accident")
    public ResponseEntity<?> findAllAccident() {
        return ResponseEntity.status(HttpStatus.OK).body(accidentService.findAll());
    }

    @GetMapping("/vehicle")
    public ResponseEntity<?> findAllVehicle() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAll());
    }

    @GetMapping("/vehicle/patents")
    public ResponseEntity<?> findAllPatentsVehicle() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAllPatents());
    }

    @GetMapping("/vehicle/patentsAndBrands")
    public ResponseEntity<?> findAllPatentsAndBrandVehicle() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAllPatentsAndBrand());
    }

    @GetMapping("/vehicle/currentYear")
    public ResponseEntity<?> findAllByCurrentYear() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAllByCurrentYear());
    }

    @GetMapping("/vehicle/findAllByCostGreaterThan/{cost}")
    public ResponseEntity<?> findAllByCostGreaterThan(@PathVariable Double cost) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAllByCostGreaterThan(cost));
    }
}
