package com.meli.autos.controller;


import com.meli.autos.dto.response.VehicleDTO;
import com.meli.autos.dto.request.VehicleEntryDTO;
import com.meli.autos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAll(){
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VehicleDTO>> getById(@PathVariable long id){
        HttpStatus httpStatus = vehicleService.getById(id).isPresent() ?HttpStatus.FOUND : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(vehicleService.getById(id), httpStatus);
    }

    @GetMapping("/dates" )
    public ResponseEntity<List<VehicleDTO>> getAllByDate(@RequestParam String since, @RequestParam String to ){

        return new ResponseEntity<List<VehicleDTO>>(vehicleService.getAllByDateRange(since,to),HttpStatus.FOUND);
    }

    @GetMapping("/prices" )
    public ResponseEntity<List<VehicleDTO>> getAllByPrice(@RequestParam String since, @RequestParam String to ){
        return new ResponseEntity<List<VehicleDTO>>(vehicleService.getAllByPriceRange(since,to),HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleEntryDTO vehicleDTO){
        vehicleService.addVehicle(vehicleDTO);
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDTO), HttpStatus.CREATED);
    }
}
