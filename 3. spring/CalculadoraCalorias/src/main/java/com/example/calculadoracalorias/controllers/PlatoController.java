package com.example.calculadoracalorias.controllers;

import com.example.calculadoracalorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/platos")
public class PlatoController {
    @Autowired
    private PlatoService platoService;

    @GetMapping("/calorias/{name}")
    public ResponseEntity<?> caloriasTotalesPlato(@PathVariable String name, @RequestParam double peso){
        try {
            return ResponseEntity.ok(platoService.caloriasPlato(name,peso));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/receta/{name}")
    public ResponseEntity<?> recetaPlato(@PathVariable String name, @RequestParam double peso){
        try {
            return ResponseEntity.ok(platoService.ingredientesPlato(name,peso));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/ingrediente-calorico/{name}")
    public ResponseEntity<?> ingredienteMasCaloricoPlato(@PathVariable String name, @RequestParam double peso){
        try {
            return ResponseEntity.ok(platoService.ingredienteMasCaloricoPlato(name,peso));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }



}
