package com.spring.calculadoracalorias.controller;

import com.spring.calculadoracalorias.service.DishServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/CaloriesCalculator")
public class CalculatorController {

    private final DishServiceImpl service;

    public CalculatorController(DishServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/caloricReport/{name}/{grams}")
    public ResponseEntity<?> caloricReport(@PathVariable String name, @PathVariable int grams) {
        return ResponseEntity.ok(service.caloricReport(name, grams));
    }

}
