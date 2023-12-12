package org.ejercicio.restaurante.repository;

import org.ejercicio.restaurante.entity.Dish;
import org.ejercicio.restaurante.entity.Food;

public interface IRestaurantRepository {

    Dish findDishByName(String dishName);

    Food getFoodByName(String name);
}
