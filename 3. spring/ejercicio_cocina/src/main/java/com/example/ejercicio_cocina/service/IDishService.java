package com.example.ejercicio_cocina.service;

import com.example.ejercicio_cocina.dto.DishDto;

import java.util.List;

public interface IDishService {
    public List<DishDto> getAllDishes(String variable);
}
