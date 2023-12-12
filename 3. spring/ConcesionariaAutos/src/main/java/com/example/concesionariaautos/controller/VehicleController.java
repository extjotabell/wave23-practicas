package com.example.concesionariaautos.controller;

import com.example.concesionariaautos.dto.VehicleDTO;
import com.example.concesionariaautos.entity.Vehicle;
import com.example.concesionariaautos.exception.VehicleNotFound;
import com.example.concesionariaautos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable int id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getVehicles() {
        return ResponseEntity.ok(vehicleService.getVehicles());
    }

    /*        public ResponseEntity<?> (){

        }*/
    @GetMapping("/dates")
    public ResponseEntity<?> getVehiclesByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date since,
                                               @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date to) {
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByDate(since, to);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getVehiclesByDate(@RequestParam double since, @RequestParam double to) {
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByPrice(since, to);
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping("/")
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
    }
}
