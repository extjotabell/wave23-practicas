package com.spring.calorias.services;

import com.spring.calorias.dtos.DishDto;

public interface IDishService {

    DishDto getDishInfoByDishName(String dishName);
}
