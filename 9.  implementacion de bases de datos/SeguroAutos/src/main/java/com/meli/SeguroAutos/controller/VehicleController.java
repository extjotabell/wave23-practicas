package com.meli.SeguroAutos.controller;

import com.meli.SeguroAutos.dto.ResponseDTO;
import com.meli.SeguroAutos.dto.VehicleRequestDTO;
import com.meli.SeguroAutos.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createAccident(@RequestBody VehicleRequestDTO vehicleRequestDTO){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/find/patents")
    public ResponseEntity<?> findPatentsAllVehicles(){
        return new ResponseEntity<>(vehicleService.findPatentAllVehicles(), HttpStatus.OK);
    }
}
