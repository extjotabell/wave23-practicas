package com.spring.calculadoracalorias.repository.interfaces;

import com.spring.calculadoracalorias.entity.Dish;

public interface IDishRepository {

    Dish getDishByName(String name);
}
