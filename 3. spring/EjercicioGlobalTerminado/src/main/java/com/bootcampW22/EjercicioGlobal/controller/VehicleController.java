package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.websocket.server.PathParam;
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
    public ResponseEntity<?> saveVehicles(@RequestBody VehicleDto vehicleDto){
        vehicleService.addVehicle(vehicleDto);
        return new ResponseEntity<>("Vehículo creado exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> searchVehicleColorYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.searchVehiclesColorYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> searchVehicleBrandBetweenYears(@PathVariable String brand,
                                                    @PathVariable int start_year,
                                                    @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.searchVehicleBrandBetweenYears(brand,start_year,end_year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> averageSpeedBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageSpeedBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> saveVehicles(@RequestBody List<VehicleDto> vehicles){
        vehicleService.saveVehicles(vehicles);
        return new ResponseEntity<>("Vehículos creados exitosamente.", HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable int id, @RequestParam int speed){
        vehicleService.updateSpeed(id, speed);
        return new ResponseEntity<>("Velocidad del vehículo actualizada exitosamente.", HttpStatus.OK);
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> fuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.fuelType(type), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable int id){
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>("Vehículo eliminado exitosamente.", HttpStatus.OK);
    }

    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> transmissionType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.transmissionType(type), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable int id, @RequestParam String fuel){
        vehicleService.updateFuel(id, fuel);
        return new ResponseEntity<>("Tipo de combustible del vehículo actualizado exitosamente.", HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> averageCapacityBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageCapacityBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/vehicles/dimensions?length={min_length}-{max_length}&width={min_width}-{max_width}")
    public ResponseEntity<?> vehiclesBetweenDimensions(@PathVariable Double min_length,
                                                       @PathVariable Double max_length,
                                                       @PathVariable Double min_width,
                                                       @PathVariable Double max_width){
        return new ResponseEntity<>(vehicleService.searchVehicleBrandBetweenYears(min_length,max_length,min_width,max_width), HttpStatus.OK);
    }
}
