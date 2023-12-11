package com.meli.foodapi.repository;

import com.meli.foodapi.entity.Dish;
import com.meli.foodapi.entity.Ingredient;

import java.util.List;

public interface IFoodRepository {
    List<Ingredient> getAllIngredients();
    List<Dish> getAllDishes();
}
