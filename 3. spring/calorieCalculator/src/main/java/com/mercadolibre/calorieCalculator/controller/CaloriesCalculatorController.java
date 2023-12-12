package com.mercadolibre.calorieCalculator.controller;

import com.mercadolibre.calorieCalculator.service.ICaloriesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to handle requests related to calorie calculation.
 */
@RestController
@RequestMapping("api/calories")
public class CaloriesCalculatorController {

    @Autowired
    private ICaloriesCalculatorService service;

    /**
     * Retrieves calorie information for a specific dish.
     *
     * @param dish Name of the dish for which calorie information is requested.
     * @return ResponseEntity with the calorie information of the dish in DishDTO format.
     */
    @GetMapping("/getDishCalories/{dish}")
    public ResponseEntity<?> getDishCalories(@PathVariable String dish){
        try {
            return new ResponseEntity<>(service.calculateDishCalories(dish), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al intentar obtener las calorías del plato");
        }
    }
}
