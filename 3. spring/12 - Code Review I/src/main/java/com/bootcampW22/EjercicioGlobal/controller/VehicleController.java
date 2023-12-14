package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.DatoStringDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@Valid @RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.findByColorAndYear(color,year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findByBrandAndYears(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year ){
        return new ResponseEntity<>(vehicleService.findByBrandAndYears(brand,start_year,end_year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getSpeedAverageByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getSpeedAverageByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addVehicles(@RequestBody List<VehicleDto> vehicles){
        return new ResponseEntity<>(vehicleService.addVehicles(vehicles), HttpStatus.CREATED);
    }

    @PutMapping ("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id, @RequestBody DatoStringDTO update_speed){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, update_speed), HttpStatus.OK);
    }

    @GetMapping ("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getByFuelType(type), HttpStatus.CREATED);
    }

    @DeleteMapping ("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping ("/vehicles/transmission/{type}")
    public ResponseEntity<?> getByTransmissionType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getByTransmissionType(type), HttpStatus.OK);
    }

    @PutMapping ("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable Long id, @RequestBody DatoStringDTO update_fuel){
        return new ResponseEntity<>(vehicleService.updateFuel(id,update_fuel), HttpStatus.OK);
    }

    @GetMapping ("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getCapacityAverageByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getCapacityAverageByBrand(brand), HttpStatus.OK);
    }

    @GetMapping ("/vehicles/dimensions")
    public ResponseEntity<?> getVehiclesByDimensions(@RequestParam String lengthRange,
                                                     @RequestParam String widthRange){
        return new ResponseEntity<>(vehicleService.getVehiclesByDimensions(lengthRange,widthRange), HttpStatus.OK);
    }

    @GetMapping ("/vehicles/weight")
    public ResponseEntity<?> getVehiclesByWeight(@RequestParam double min,
                                                 @RequestParam double max){
        return new ResponseEntity<>(vehicleService.getVehiclesByWeight(min,max), HttpStatus.OK);
    }
}
