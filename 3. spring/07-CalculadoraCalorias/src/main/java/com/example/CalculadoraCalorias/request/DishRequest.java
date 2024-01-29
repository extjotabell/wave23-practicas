package com.example.CalculadoraCalorias.request;

import com.example.calculadora_calorias.entity.Ingredient;

import java.util.List;

public class DishRequest {
    private final List<Ingredient> ingredients;

    public DishRequest(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
