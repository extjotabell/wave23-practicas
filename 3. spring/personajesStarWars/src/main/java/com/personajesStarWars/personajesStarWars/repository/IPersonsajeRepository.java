package com.personajesStarWars.personajesStarWars.repository;

import com.personajesStarWars.personajesStarWars.dto.PersonajeDto;
import com.personajesStarWars.personajesStarWars.entity.Personaje;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public interface IPersonsajeRepository {
    List<Personaje> getAll();
    List<Personaje> findByName(String name);
}
