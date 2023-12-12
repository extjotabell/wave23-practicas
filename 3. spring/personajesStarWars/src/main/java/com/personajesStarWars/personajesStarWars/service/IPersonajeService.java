package com.personajesStarWars.personajesStarWars.service;

import com.personajesStarWars.personajesStarWars.dto.PersonajeDto;
import com.personajesStarWars.personajesStarWars.dto.PersonajeDto;
import com.personajesStarWars.personajesStarWars.entity.Personaje;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> getAll();
    List<PersonajeDto> findByName(String name);
}
