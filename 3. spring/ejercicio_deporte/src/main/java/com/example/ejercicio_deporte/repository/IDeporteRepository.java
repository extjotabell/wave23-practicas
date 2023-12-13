package com.example.ejercicio_deporte.repository;

import com.example.ejercicio_deporte.entity.Deporte;

import java.util.List;

public interface IDeporteRepository {
    List<Deporte> findAll();
}
