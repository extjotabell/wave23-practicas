package com.caloriescalc.practice.repository.dish;

import com.caloriescalc.practice.entity.Dish;

import java.util.List;

public interface IDishRepository {
    List<Dish> getAll();

    Dish getByName(String name);
}
