package com.edadpersona.edadpersona.controllers;
import com.edadpersona.edadpersona.entities.Persona;
import com.edadpersona.edadpersona.services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    private DataServices dataServices;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int getEdad (@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        Persona persona = dataServices.obtenerEdad(dia,mes,anio);
        return persona.obtnerEdad();
    }

    @GetMapping("/{dia}/{mes}/{anio}/{nombre}")
    public Persona getPersona(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio, @PathVariable String nombre){
        return dataServices.crearPersona(dia, mes, anio,nombre);
    }

    @GetMapping("/{dia}/{mes}/{anio}/{nombre}/json")
    public Map<String,String> getPersonPear(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio, @PathVariable String nombre){
        Persona persona = dataServices.crearPersona(dia,mes,anio,nombre);
        Map<String,String> datos = new HashMap<>();
        datos.put("Nombre", persona.getNombre());
        datos.put("Edad",persona.getEdad().toString());
        return datos;
    }
}
