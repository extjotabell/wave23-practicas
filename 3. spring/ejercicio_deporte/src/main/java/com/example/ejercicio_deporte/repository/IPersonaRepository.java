package com.example.ejercicio_deporte.repository;

import com.example.ejercicio_deporte.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();
}
