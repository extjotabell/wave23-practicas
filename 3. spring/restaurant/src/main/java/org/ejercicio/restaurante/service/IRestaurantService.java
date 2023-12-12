package org.ejercicio.restaurante.service;


import org.ejercicio.restaurante.entity.DishDto;

public interface IRestaurantService {

    DishDto getAllInformationOfDishName(String dishName);
}
