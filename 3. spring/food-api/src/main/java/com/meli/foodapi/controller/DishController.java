package com.meli.foodapi.controller;


import com.meli.foodapi.dto.Request.DishEntryDTO;
import com.meli.foodapi.dto.Response.DishDTO;
import com.meli.foodapi.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dishes")
public class DishController {

    @Autowired
    IFoodService foodService;

    @GetMapping("/{name}/{weight}")
    public ResponseEntity<DishDTO> getDish(@PathVariable String name , @PathVariable int weight){
        return new ResponseEntity<>(foodService.findDish(name, weight), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DishDTO>> getDishes(@RequestBody List<DishEntryDTO> entrydishes){
        return new ResponseEntity<>(foodService.findDishes(entrydishes), HttpStatus.OK);
    }



}
