package com.calculadora.calculadoraCalorias.controller;

import com.calculadora.calculadoraCalorias.dto.request.DishEntryDTO;
import com.calculadora.calculadoraCalorias.dto.response.DishDTO;
import com.calculadora.calculadoraCalorias.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    IFoodService foodService;

    @GetMapping("/{name}/{weight}")
    ResponseEntity<DishDTO> getDish(@PathVariable String name, @PathVariable int weight) {
        return new ResponseEntity<>(foodService.findDish(name, weight), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<DishDTO>> getDishes(@RequestBody List<DishEntryDTO> entryDishes) {
        return new ResponseEntity<>(foodService.findDishes(entryDishes), HttpStatus.OK);
    }

}
