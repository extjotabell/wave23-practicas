package org.ejercicio.dealership.controller;

import org.ejercicio.dealership.entity.Vehicle;
import org.ejercicio.dealership.dto.VehicleDto;
import org.ejercicio.dealership.service.IDealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/api/vehicles")
public class DealershipController {

    @Autowired
    IDealershipService dealershipService;

    @PostMapping
    public ResponseEntity<?> AddVehicle(@RequestBody Vehicle vehicle) {
        try {
            VehicleDto vehicleDto = this.dealershipService.addVehicule(vehicle);
            return ResponseEntity.ok("Agregado correctamente! " + vehicleDto);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllVehicles() {
        try {
            List<VehicleDto> vehiclesDto = this.dealershipService.getAllVehicles();
            return ResponseEntity.ok(vehiclesDto);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/dates")
    public ResponseEntity<?> findVehiclesAccordingToDate(@RequestParam String since,
                                                         @RequestParam String to) {
        try {
            List<VehicleDto> vehiclesDto = this.dealershipService.findVehiclesAccordingToDate(since, to);
            return ResponseEntity.ok(vehiclesDto);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/prices")
    public ResponseEntity<?> findVehiclesAccordingToPrice(@RequestParam String since,
                                                          @RequestParam String to) {
        try {
            List<VehicleDto> vehiclesDto = this.dealershipService.findVehiclesAccordingToPrice(since, to);
            return ResponseEntity.ok(vehiclesDto);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{registration}")
    public ResponseEntity<?> findVehicleByRegistration(@PathVariable String registration) {
        try {
            return ResponseEntity.ok(this.dealershipService.findVehicleByRegistration(registration));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
