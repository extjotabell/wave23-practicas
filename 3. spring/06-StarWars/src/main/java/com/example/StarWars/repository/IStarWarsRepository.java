package com.starwars.startwars.repository;

import com.starwars.startwars.entity.PersonajeEntity;

import java.util.List;

public interface IStarWarsRepository {

    List<PersonajeEntity> find(String nombre);

    List<PersonajeEntity> findAll();

}