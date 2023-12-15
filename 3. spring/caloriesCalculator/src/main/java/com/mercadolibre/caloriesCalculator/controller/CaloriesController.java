package com.mercadolibre.caloriesCalculator.controller;


import com.mercadolibre.caloriesCalculator.dto.DishesWeightDto;
import com.mercadolibre.caloriesCalculator.service.CaloriesServiceImpl;
import com.mercadolibre.caloriesCalculator.service.ICaloriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calories")
public class CaloriesController {

    ICaloriesService service;

    public CaloriesController(CaloriesServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/dishes")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(service.getAllDishes(), HttpStatus.OK);
    }


    @GetMapping("/totalCalories")
    public ResponseEntity<?>getCaloriesDish(@RequestParam String nameDish, @RequestParam int weight){
       return new ResponseEntity<>(service.calculateDishCalories(nameDish, weight), HttpStatus.OK);
    }

    @PostMapping("/totalCaloriesList")
    public ResponseEntity<?>getCaloriesDishList(@RequestBody List<DishesWeightDto> dishesDto){
        return new ResponseEntity<>(service.calculateDishCaloriesList(dishesDto), HttpStatus.OK);
    }
}
