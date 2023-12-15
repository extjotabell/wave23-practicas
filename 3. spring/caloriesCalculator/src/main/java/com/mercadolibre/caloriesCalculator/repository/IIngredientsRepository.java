package com.mercadolibre.caloriesCalculator.repository;

import com.mercadolibre.caloriesCalculator.entity.Ingredients;

import java.util.List;

public interface IIngredientsRepository {
    List<Ingredients> getAllIngredients();

}
