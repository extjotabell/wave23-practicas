package com.example.ejercicio_cocina.service;

import com.example.ejercicio_cocina.dto.IngredientDto;
import com.example.ejercicio_cocina.entity.Ingredient;

import java.util.List;

public interface IIngredientService {
    public List<IngredientDto> getIngredient(String variable);
}
