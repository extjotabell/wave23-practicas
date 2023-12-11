package com.example.calculadora_calorias.entity;

import java.util.List;

public class Dish {
    private String name;
    private List<Ingredient> ingredients;

    public Dish(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
