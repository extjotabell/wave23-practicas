package com.example.CalculadoraCalorias.service;

import com.example.calculadora_calorias.dto.DishDTO;

import java.util.List;
import java.util.Optional;

public interface Service {
    Optional<DishDTO> findByName(String findParam);
    List<DishDTO> findManyByName(List<String> findParams);
}
