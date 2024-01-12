package com.example.seguroautos.controller;

import com.example.seguroautos.dto.SinisterDTO;
import com.example.seguroautos.dto.VehicleDTO;
import com.example.seguroautos.service.ApplicationService;
import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {
  private final ApplicationService service;

  public Controller(ApplicationService service) {
    this.service = service;
  }

  @PostMapping("/vehicle")
  public ResponseEntity<?> createVehicle(@RequestBody VehicleDTO vehicleDTO){
    return ResponseEntity.ok(service.createVehicle(vehicleDTO));
  }

  @PostMapping("/sinister/{vehicleId}")
  public ResponseEntity<?> createSinisterToVehicle(@RequestBody SinisterDTO sinisterDTO,  @PathVariable Integer vehicleId)
      throws NotFoundException {
    return ResponseEntity.ok(service.createSinisterToVehicle(sinisterDTO,vehicleId));
  }

  @GetMapping
  public ResponseEntity<List<VehicleDTO>> getAllVehicles(){
    return ResponseEntity.ok(service.getVehicles());
  }
  @GetMapping("/patents")
  public ResponseEntity<?> getAllPatents(){
    return ResponseEntity.ok(service.getAllPatents());
  }

  @GetMapping("/patents-model")
  public ResponseEntity<?> getAllPatentsModelOrderByYear(){
    return ResponseEntity.ok(service.getAllPatentsModelOrderByYear());
  }

  @GetMapping("/patents/wheels-greater/4")
  public ResponseEntity<?> getAllPatentsVehiclesWithNumberWheelsGreater4(){
    return ResponseEntity.ok(service.getAllPatentsVehiclesWithNumberWheelsGreater4());
  }

  @GetMapping("/vehicles/sinisters/greater/10000")
  public ResponseEntity<?> getAllVehiclesWithSinisterEconomicLossGreaterThan10000(){
    return ResponseEntity.ok(service.getAllVehiclesWithSinisterEconomicLossGreaterThan10000());
  }
  @GetMapping("/vehicles/sinisters/greater/10000/total")
  public ResponseEntity<?> getAllVehiclesWithSinisterEconomicLossGreaterThan10000Total(){
    return ResponseEntity.ok(service.getAllVehiclesWithSinisterEconomicLossGreaterThan10000WithLoss());
  }
}
