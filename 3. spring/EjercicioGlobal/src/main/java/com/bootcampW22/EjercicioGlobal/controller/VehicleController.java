package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> createVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
        vehicleService.create(vehicleDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String color, @PathVariable int year) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findByColorAndYear(color, year));
    }

    @GetMapping("/vehicles/brand/{brand}/between/{startYear}/{endYear}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String brand, @PathVariable int startYear, @PathVariable int endYear) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findByBrandAndYearRange(brand, startYear, endYear));
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable String brand) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAverageSpeedByBrand(brand));
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> createBatch(@RequestBody List<VehicleDto> vehicleDtos) {
        vehicleService.createBatch(vehicleDtos);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/vehicles/{id}/update_speed/{maxSpeed}")
    public ResponseEntity<?> updateMaxSpeed(@PathVariable Long id, @PathVariable String maxSpeed) {
        vehicleService.updateMaxSpeed(id, maxSpeed);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/vehicles/fuel_type/{fuelType}")
    public ResponseEntity<?> findByFuelType(@PathVariable String fuelType) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findByFuelType(fuelType));
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/vehicle/transmission/{type}")
    public ResponseEntity<?> findByTransmission(@PathVariable String type) {
        return ResponseEntity.ok(vehicleService.findByTransmission(type));
    }

    @PutMapping("/vehicles/{id}/update_fuel/{type}")
    public ResponseEntity<?> updateFuelType(@PathVariable Long id, @PathVariable String type) {
        vehicleService.updateFuelType(id, type);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacityByBrand(@PathVariable String brand) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAverageCapacityByBrand(brand));
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> findByDimensions(@RequestParam String heightRange, @RequestParam String widthRange) {
        return ResponseEntity.ok(vehicleService.findByDimensions(heightRange, widthRange));
    }

    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> findByWeightRange(@RequestParam double minWeight, double maxWeight) {
        return ResponseEntity.ok(vehicleService.findByWeightRange(minWeight, maxWeight));
    }
}
