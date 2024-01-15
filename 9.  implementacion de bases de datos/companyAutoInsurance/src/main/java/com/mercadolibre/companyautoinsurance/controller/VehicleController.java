package com.mercadolibre.companyautoinsurance.controller;

import com.mercadolibre.companyautoinsurance.models.dtos.VehicleDTO;
import com.mercadolibre.companyautoinsurance.models.dtos.VehicleWithTotalLossDTO;
import com.mercadolibre.companyautoinsurance.services.IVehicleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/saveVehicle")
    public ResponseEntity<VehicleDTO> saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        return new ResponseEntity<>(vehicleService.saveVehicle(vehicleDTO), HttpStatus.OK);
    }

    @GetMapping("/patents")
    public ResponseEntity<List<String>> findAllRegisteredVehiclesPatents(){
        return ResponseEntity.ok(vehicleService.findAllRegisteredVehiclesPatents());
    }

    @GetMapping("/patents-brands")
    public ResponseEntity<List<VehicleDTO>> findAllPatentAndBrandVehiclesOrderByYearFabrication(){
        return ResponseEntity.ok(vehicleService.findAllPatentAndBrandVehiclesOrderByYearFabrication());
    }

    @GetMapping("/4-wheels")
    public ResponseEntity<List<String>> findAllVehiclesWithMoreThanFourWheelsAndManufacturedThisYear(){
        return ResponseEntity.ok(vehicleService.findAllPatentVehiclesWithMoreThanFourWheelsAndManufacturedThisYear());
    }

    @GetMapping("/accidents-loss")
    public ResponseEntity<List<VehicleDTO>> findAllVehiclesWithAccidentsWithLossGreaterThan10000(){
        return ResponseEntity.ok(vehicleService.findAllPatentBrandAndModelVehiclesWithAccidentsWithLossGreaterThan10000());
    }

    @GetMapping("/accidents-loss-total")
    public ResponseEntity<VehicleWithTotalLossDTO> findAllVehiclesWithAccidentsWithLossGreaterThan10000AndTotalLoss(){
        return ResponseEntity.ok(vehicleService.findPatentBrandAndModelVehiclesWithAccidentsWithLossGreaterThan10000AndTotalLoss());
    }

}
