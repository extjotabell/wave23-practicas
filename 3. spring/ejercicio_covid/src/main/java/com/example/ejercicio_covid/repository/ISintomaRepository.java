package com.example.ejercicio_covid.repository;

import com.example.ejercicio_covid.entitie.Sintoma;

import java.util.List;

public interface ISintomaRepository {
    List<Sintoma> findAll();
}
