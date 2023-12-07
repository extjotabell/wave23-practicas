package com.example.ejercicio_edad.controllers;

import com.example.ejercicio_edad.entities.Persona;
import com.example.ejercicio_edad.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/edad")
public class PersonaController {

    private PersonaService personaService = new PersonaService();
    @GetMapping("/{dia}/{mes}/{ano}")
    public Persona getCalculoEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano){
        return personaService.concatenarFecha(dia,mes,ano);
    }
}
