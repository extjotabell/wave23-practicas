package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vehicles")
@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.filterByColorAndYear(color,year), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getByRangeDate(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.filterByBrandAndRangeDate(brand, start_year,end_year), HttpStatus.OK);
    }
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<Double> getAverageSpeedByBrand(@PathVariable String brand){
        return  new ResponseEntity<>(vehicleService.getAverageSpeedByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{type}")
    public  ResponseEntity<List<VehicleDto>> filterByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.filterByFuelType(type), HttpStatus.OK);
    }

    @GetMapping("/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> filterBytransmission(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.filterByTransmission(type),HttpStatus.OK);
    }
    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<Double> getAverageCapacity(@PathVariable String brand){
        return  new ResponseEntity<>(vehicleService.getAverageCapacity(brand), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehicleDto> saveNewVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.save(vehicleDto), HttpStatus.CREATED);
    }
    @PostMapping("/batch")
    public ResponseEntity<List<VehicleDto>> saveNewVehicles(@RequestBody List<VehicleDto> vehiclesDto) {
        return new ResponseEntity<>(vehicleService.save(vehiclesDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<VehicleDto> updateSpeed(@PathVariable Long id, @RequestBody String newSpeed){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, newSpeed), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_fuel")
    public  ResponseEntity<VehicleDto> updateFuel(@PathVariable Long  id, @RequestBody String fuel){
        return new ResponseEntity<>(vehicleService.updateFuel(id, fuel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        vehicleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
