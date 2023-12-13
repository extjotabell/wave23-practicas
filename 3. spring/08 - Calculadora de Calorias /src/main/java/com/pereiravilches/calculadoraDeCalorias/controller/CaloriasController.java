package com.pereiravilches.calculadoraDeCalorias.controller;

import com.pereiravilches.calculadoraDeCalorias.exception.PlateNotFoundException;
import com.pereiravilches.calculadoraDeCalorias.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calculadora-de-calorias/")
public class CaloriasController {

    @Autowired
    IFoodService foodService;

    @GetMapping
    public ResponseEntity<?> calcularCantidadCalorias(@RequestParam String plato) {
        try {
            return new ResponseEntity<>(foodService.calcularCalorias(plato), HttpStatus.OK);
        } catch (PlateNotFoundException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("platos")
    public ResponseEntity<?> calcularCantidadCalorias(@RequestParam List<String> platos) {
        try{
            return new ResponseEntity<>(foodService.calcularCaloriasListPlatos(platos), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("findAllPlatos")
    public ResponseEntity<?> verTodosLosPlatos(){
        try{
            return new ResponseEntity<>(foodService.findAllPlatos(), HttpStatus.OK);
        }catch (Exception e){
         return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
