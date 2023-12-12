package com.example.personajesstarwars.repository;

import com.example.personajesstarwars.dto.PersonajeDTO;
import com.example.personajesstarwars.entity.Personaje;

import java.util.List;

public interface RepositoryPersonaje {
    List<PersonajeDTO> getPersonajes();
}
