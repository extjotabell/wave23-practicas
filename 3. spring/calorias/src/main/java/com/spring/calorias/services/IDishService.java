package com.spring.calorias.services;

import com.spring.calorias.dtos.DishDto;
import com.spring.calorias.dtos.RequestDishDto;

import java.util.List;

public interface IDishService {

    DishDto getDishInfoByDishName(String dishName);

    DishDto getDishInfoByDishNameAndWeight(String dishName, Double dishWeight);

    List<DishDto> getDishesInfoByDishesNames(List<RequestDishDto> dishes);
}
