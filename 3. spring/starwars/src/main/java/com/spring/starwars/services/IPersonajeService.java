package com.spring.starwars.services;

import com.spring.starwars.dtos.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> findAll();
    List<PersonajeDto> searchByName(String name);

}
