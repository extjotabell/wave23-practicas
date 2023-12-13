package com.spring.starwars.repository;

import com.spring.starwars.entity.Personaje;

import java.util.List;

public interface IStarWarsRepository {
    List<Personaje> findByName(String name);

    List<Personaje> findAll();
}
