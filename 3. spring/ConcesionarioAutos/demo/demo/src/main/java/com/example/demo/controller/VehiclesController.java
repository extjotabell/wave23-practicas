package com.example.demo.controller;

import com.example.demo.models.Car;
import com.example.demo.models.CarDTO;
import com.example.demo.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")
public class VehiclesController {

    @Autowired
    VehiclesService vehiclesService;

    @PostMapping
    public boolean addCar(@RequestBody Car car){
        return vehiclesService.addCar(car);
    }

    @GetMapping
    public List<CarDTO> getCars(){
        return vehiclesService.getCars();
    }

    @GetMapping("dates")
    public List<Car> getCarsBetweenDates(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                            @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        return vehiclesService.getCarsBetweenDates(since, to);
    }

    @GetMapping("prices")
    public List<Car> getCarsBetweenPrices(@RequestParam Double since, @RequestParam Double to){
        return vehiclesService.getCarsBetweenPrices(since, to);
    }

    @GetMapping("{id}")
    public Car getCarsBetweenPrices(@PathVariable Long id){
        return vehiclesService.getCar(id);
    }
}
