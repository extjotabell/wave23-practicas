package com.example.CalculadoraCalorias.controller;

import com.example.calculadora_calorias.dto.DishDTO;
import com.example.calculadora_calorias.service.DishesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DishesController {

    private final DishesService dishesService;

    public DishesController(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    @GetMapping("/{findParam}")
    public ResponseEntity<DishDTO> findByName(@PathVariable String findParam) {
        return dishesService.findByName(findParam).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findManyByName")
    public ResponseEntity<List<DishDTO>> findManyByName(@RequestParam List<String> findParams) {
        return ResponseEntity.ok(dishesService.findManyByName(findParams));
    }
}
