package com.example.CalculadoraCalorias.dto;

import com.example.calculadora_calorias.entity.Dish;
import com.example.calculadora_calorias.entity.Ingredient;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DishDTO {
    private String name;
    private List<Ingredient> ingredients;
    private Ingredient highestCaloryIngredient;

    public DishDTO(Dish dish) {
        name = dish.getName();
        ingredients = dish.getIngredients();
        highestCaloryIngredient = dish.getIngredients().stream()
                .sorted(Comparator.comparing(Ingredient::getCalories)).toList().get(ingredients.size() - 1);
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient getHighestCaloryIngredient() {
        return highestCaloryIngredient;
    }
}
