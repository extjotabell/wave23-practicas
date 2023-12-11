package com.bootcamp.edad.controller;

import com.bootcamp.edad.entity.Persona;
import com.bootcamp.edad.services.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/edad")
public class EdadRest {

    @Autowired
    private EdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        Persona persona = edadService.obtenerEdad(dia, mes, anio);
        return persona.obtenerEdad();
    }

    @GetMapping("/{dia}/{mes}/{anio}/{nombre}")
    public Persona getPersona(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio, @PathVariable String nombre){
        return edadService.crearPersona(dia, mes, anio, nombre);
    }

    @GetMapping("/{dia}/{mes}/{anio}/{nombre}/json")
    public Map<String, String> getPersonaMap(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio, @PathVariable String nombre){
        Persona persona = edadService.crearPersona(dia, mes, anio, nombre);
        Map<String, String> mapa = new HashMap<>();
        mapa.put("Nombre", persona.getNombre());
        mapa.put("Edad", persona.getEdad().toString());
        return mapa;
    }

}
