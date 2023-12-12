package com.spring.calculadoracalorias.repository.interfaces;

import com.spring.calculadoracalorias.entity.Ingredient;

public interface IIngredientRepository {
    Ingredient getIngredientByName(String name);
}
