package com.example.ejercicio_covid.repository;

import com.example.ejercicio_covid.entitie.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();
}
