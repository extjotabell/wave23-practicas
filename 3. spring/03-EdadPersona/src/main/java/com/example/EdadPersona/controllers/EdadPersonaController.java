package com.example.EdadPersona.controllers;

import com.example.edad_persona.dto.Persona;
import com.example.edad_persona.services.EdadPersonaService;
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