package com.example.personajesstarwars.service;

import com.example.personajesstarwars.dto.PersonajeDTO;
import com.example.personajesstarwars.entity.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServicePersonaje {
    List<PersonajeDTO> findByName(String name);
}
