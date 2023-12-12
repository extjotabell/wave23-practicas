package com.meli.concesionaria.controller;

import com.meli.concesionaria.dto.VehicleDTO;
import com.meli.concesionaria.entity.Vehicle;
import com.meli.concesionaria.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @PostMapping()
    public ResponseEntity<VehicleDTO> save(@RequestBody VehicleDTO vehicle){
        VehicleDTO response = service.save(vehicle);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<VehicleDTO>> getAllVehicles(){
        List<VehicleDTO> response = service.getAllVehicles();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getAllByDates(@RequestParam String since, @RequestParam String to){
        List<VehicleDTO> response = service.getAllByDates(since,to);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getAllByPrice(@RequestParam Double since, @RequestParam Double to){
        List<VehicleDTO> response  = service.getAllByPrice(since,to);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getById(@PathVariable long id){
        VehicleDTO response = service.getById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
