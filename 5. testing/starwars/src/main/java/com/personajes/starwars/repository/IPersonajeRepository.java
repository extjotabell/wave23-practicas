package com.personajes.starwars.repository;

import com.personajes.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findAll();

}
