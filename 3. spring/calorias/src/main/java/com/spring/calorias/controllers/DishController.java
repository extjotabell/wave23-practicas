package com.spring.calorias.controllers;

import com.spring.calorias.dtos.RequestDishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.calorias.services.IDishService;
import com.spring.calorias.dtos.DishDto;

import java.util.List;

@RestController
@RequestMapping("/resto-api/dishes")
public class DishController {
    @Autowired
    private IDishService dishService;

    @GetMapping("/{dishName}")
    public ResponseEntity<?> getDishInfoByDishName(@PathVariable String dishName) {
        DishDto dishDto = dishService.getDishInfoByDishName(dishName);
        if(dishDto != null){
            return ResponseEntity.ok(dishDto);
        }
        return new ResponseEntity<>("Not found dish with name: "+dishName, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{dishName}/{dishWeight}")
    public ResponseEntity<?> getDishInfoByDishNameAndWeight(@PathVariable String dishName, @PathVariable Double dishWeight) {
        DishDto dishDto = dishService.getDishInfoByDishNameAndWeight(dishName, dishWeight);
        if(dishDto != null){
            return ResponseEntity.ok(dishDto);
        }
        return new ResponseEntity<>("Not found dish with name: "+dishName, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<DishDto>> getDishesInfoByDishNameList(@RequestBody List<RequestDishDto> dishes) {
        return ResponseEntity.ok(dishService.getDishesInfoByDishesNames(dishes));
    }

}
