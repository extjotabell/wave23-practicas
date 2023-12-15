package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }


    @GetMapping()
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }
    //1
    @PostMapping
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody VehicleDto vehicleDto){
        VehicleDto response = vehicleService.saveVehicle(vehicleDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    //2
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getAllByColorAndYear(@PathVariable String color, @PathVariable int year){
        List<VehicleDto> response = vehicleService.getAllByColorAndYear(color,year);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //3
    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getAllByBrandAndYear(@PathVariable String brand, @PathVariable int start_year,@PathVariable int end_year){
        List<VehicleDto> response = vehicleService.getAllByBrandAndYear(brand,start_year,end_year);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    //4
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getMaxSpeedAverageByBrand(@PathVariable String brand){
        double response = vehicleService.getMaxSpeedAverageByBrand(brand);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    //5
    @PostMapping("/batch")
    public ResponseEntity<List<VehicleDto>> saveAll(@RequestBody List<VehicleDto> vehicleDtoList){
        List<VehicleDto> response = vehicleService.saveAll(vehicleDtoList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    //6
    @PutMapping("/{id}/update_speed")
    public ResponseEntity<VehicleDto> updateSpeed(@PathVariable long id,@RequestParam double speed){
        VehicleDto response = vehicleService.updateSpeed(id,speed);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    //7
    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getAllByFuelType(@PathVariable String type){
        List<VehicleDto> response = vehicleService.getAllByFuelType(type);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    //8
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        Boolean response = vehicleService.delete(id);
        return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
    }
    //9
    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> getByTransmission(@PathVariable String type){
        List<VehicleDto> response = vehicleService.getByTransmission(type);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    //10
    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable long id, @RequestParam String fuel){
        VehicleDto response = vehicleService.updateFuel(id,fuel);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    //11
    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> getCapacityByBrand(@PathVariable String brand){
        int response = vehicleService.getCapacityByBrand(brand);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    //12
    @GetMapping("/dimensions?length={min_length}-{max_length}&width={min_width}-{max_width}")
    public ResponseEntity<List<VehicleDto>> getByDimensions(@PathVariable double length,@PathVariable double width){
        List<VehicleDto> response = vehicleService.getByDimensions(length,width);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    //13
    @GetMapping("/weight?min={weight_min}&max={weight_max}")
    public ResponseEntity<List<VehicleDto>> getAllByWeight(@PathVariable double weight_min,@PathVariable double weight_max){
        List<VehicleDto> response = vehicleService.getAllByWeight(weight_min,weight_max);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }



}
