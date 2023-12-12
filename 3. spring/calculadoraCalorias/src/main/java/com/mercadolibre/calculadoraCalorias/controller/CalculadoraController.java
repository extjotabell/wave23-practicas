package com.mercadolibre.calculadoraCalorias.controller;

import com.mercadolibre.calculadoraCalorias.dto.request.RecetaRequestDto;
import com.mercadolibre.calculadoraCalorias.service.CalculadoraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculadoraController {
    @Autowired
    CalculadoraServiceImpl service;

    @GetMapping("/calcularCalorias")
    public ResponseEntity<?> obtenerCalorias(@RequestBody RecetaRequestDto receta) {
        try {
            return new ResponseEntity<>(service.calcularCalorias(receta), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerIngredientes")
    public ResponseEntity<?> obtenerIngredientes(@RequestBody RecetaRequestDto receta) {
        try {
            return new ResponseEntity<>(service.obtenerIngredientes(receta), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ingredienteMayorCantidadCalorias")
    public ResponseEntity<?> getIngredienteMayorCantidadCalorias(@RequestBody RecetaRequestDto receta) {
        try {
            return new ResponseEntity<>(service.mayorCantidadDeCalorias(receta), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
