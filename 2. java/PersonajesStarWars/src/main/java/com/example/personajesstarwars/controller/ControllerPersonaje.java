package com.example.personajesstarwars.controller;


import com.example.personajesstarwars.dto.PersonajeDTO;
import com.example.personajesstarwars.service.ServicePersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personajes")
public class ControllerPersonaje {
    @Autowired
    private ServicePersonaje servicePersonaje;

    public ControllerPersonaje(ServicePersonaje servicePersonaje) {
        this.servicePersonaje = servicePersonaje;
    }

    @GetMapping("/{name}")
    public List<PersonajeDTO> personajesContieneNombre(@PathVariable String name){
        return servicePersonaje.findByName(name);
    }
}
