package com.spring.calorias.repositories;

import com.spring.calorias.model.Dish;
import com.spring.calorias.model.Food;

import java.util.List;

public interface IRestoRepository {
    List<Food> getFoodList();
    Food getFoodByName(String name);
    Dish getDishByName(String name);
}
