package com.example.ejercicio_cocina.repository;

import com.example.ejercicio_cocina.entity.Dish;

import java.util.List;

public interface IDishRepository {
    List<Dish> getAllDishes();
}
