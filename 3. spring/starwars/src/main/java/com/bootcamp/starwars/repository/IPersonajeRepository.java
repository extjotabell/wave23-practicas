package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeRepository {

    List<PersonajeDTO> getAllPersonajes();

    List<PersonajeDTO> getPersonajeByName(String name);

}
