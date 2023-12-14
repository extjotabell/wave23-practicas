package com.itbootcamp.EjercicioVehiculos.controller;

import com.itbootcamp.EjercicioVehiculos.dto.request.VehicleRequestDto;
import com.itbootcamp.EjercicioVehiculos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody VehicleRequestDto newVehicle){
        return ResponseEntity.ok(vehicleService.save(newVehicle));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return ResponseEntity.ok(vehicleService.findById(id));
    }

    @GetMapping("/dates")
    public ResponseEntity<?> findByDatesRange(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(vehicleService.findDatesRange(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<?> findByPriceRange(@RequestParam int since, @RequestParam int to){
        return ResponseEntity.ok(vehicleService.findByPriceRange(since, to));
    }

}
