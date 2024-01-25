package com.example.covid.repository;

import com.example.covid.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();
}
