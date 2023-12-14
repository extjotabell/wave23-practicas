package com.caloriescalc.practice.repository.food;

import com.caloriescalc.practice.entity.Ingredient;

import java.util.List;

public interface IFoodRepository {
    List<Ingredient> getAll();
}
