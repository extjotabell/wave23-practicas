package com.personajes.starwars.service;

import com.personajes.starwars.dto.request.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> findMatches(String pattern);
}
