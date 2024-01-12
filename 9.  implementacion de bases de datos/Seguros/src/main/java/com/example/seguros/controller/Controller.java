package com.example.seguros.controller;

import com.example.seguros.dto.AccidentRequestDTO;
import com.example.seguros.dto.VehicleRequestDTO;
import com.example.seguros.service.accident.AccidentService;
import com.example.seguros.service.vehicle.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
