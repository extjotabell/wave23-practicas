package com.example.edaddeunapersona.controllers;


import com.example.edaddeunapersona.dto.Persona;
import com.example.edaddeunapersona.services.EdadPersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EdadPersonaController {

    private final EdadPersonaService edadPersonaService;

    public EdadPersonaController(EdadPersonaService edadPersonaService) {
        this.edadPersonaService = edadPersonaService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public int calcularEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return edadPersonaService.calcularEdad(day, month, year);
    }

    @PostMapping("/{day}/{month}/{year}")
    public Persona agregarPersona(@PathVariable int day, @PathVariable int month, @PathVariable int year, @RequestBody Persona persona) {
        edadPersonaService.agregarPersona(persona, day, month, year);
        return persona;
    }

    @GetMapping("/listAll")
    public List<Persona> listAll() {
        return edadPersonaService.getPersonas();
    }
}