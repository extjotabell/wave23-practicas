package com.example.calculadoracalorias.controllers;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {
    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/{name}")
    public ResponseEntity<?> findIngredienteByName(@PathVariable String name){
        try {
            IngredienteDTO ingrediente = ingredienteService.findIngredienteByName(name);
            return ResponseEntity.ok(ingrediente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
