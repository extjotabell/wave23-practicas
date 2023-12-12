package com.spring.starwars.repositories;

import com.spring.starwars.entities.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    List<Personaje> getPersonajes();

    List<Personaje> getPersonajesByName(String name);
}