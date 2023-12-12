package com.spring.calorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.calorias.services.IDishService;
import com.spring.calorias.dtos.DishDto;

@RestController
@RequestMapping("/resto-api")
public class DishController {
    @Autowired
    private IDishService dishService;

    @GetMapping("/{dishName}")
    public ResponseEntity<?> getTotalCalories(@PathVariable String dishName) {
        return ResponseEntity.ok(dishService.getDishInfoByDishName(dishName));
    }
}
