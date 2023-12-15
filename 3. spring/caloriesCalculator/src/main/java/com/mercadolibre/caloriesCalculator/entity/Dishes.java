package com.mercadolibre.caloriesCalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@AllArgsConstructor
@Getter
public class Dishes {
    private String nameDishes;
    private int weightDishes;
    private List<Ingredients> listIngredients;
}
