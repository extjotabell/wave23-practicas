package com.calculadora.calculadoraCalorias.repository;

import com.calculadora.calculadoraCalorias.entity.Dish;
import com.calculadora.calculadoraCalorias.entity.Ingredient;

import java.util.List;

public interface IFoodRepository {
    List<Ingredient> getAllIngredients();
    List<Dish> getAllDishes();
}
