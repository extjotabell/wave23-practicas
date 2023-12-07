package com.spring.edaddeunapersona.controller;

import com.spring.edaddeunapersona.entities.Persona;
import com.spring.edaddeunapersona.services.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @GetMapping("/{dia}/{mes}/{anio}/{nombre}")
    public Persona ConsultarEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio, @PathVariable String nombre) {
        return new PersonaService().calcularEdad(dia, mes, anio, nombre);
    }
}
