package com.example.InsuranceCompany.controller;

import com.example.InsuranceCompany.dto.VehicleDTO;
import com.example.InsuranceCompany.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    VehicleService service;

    @GetMapping("/")
    public ResponseEntity<?> getAllVehicles() {
        return new ResponseEntity<>(service.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/getVehicle/{id}")
    public ResponseEntity<?> getVehicle(@PathVariable Long id) {
        return new ResponseEntity<>(service.getVehicleById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addVehicle(VehicleDTO vehicleDTO){
        return new ResponseEntity<>(service.addvehicle(vehicleDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestBody VehicleDTO vehicle){
        return new ResponseEntity<>(service.updateVehicle(id, vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteVehicle(id), HttpStatus.OK);
    }

}
