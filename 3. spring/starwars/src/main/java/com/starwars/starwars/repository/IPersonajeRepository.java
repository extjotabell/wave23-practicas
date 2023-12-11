package com.starwars.starwars.repository;

import com.starwars.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonaje(String nombre);

    List<Personaje> mostrar();
}
