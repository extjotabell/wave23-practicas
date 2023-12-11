package com.example.calculadora_calorias.repository;

import com.example.calculadora_calorias.entity.Dish;

import java.util.List;
import java.util.Optional;

public interface Repository {
    Optional<Dish> findByName(String findParam);
    List<Dish> findManyByName(List<String> findParams);
}
