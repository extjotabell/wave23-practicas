package com.caloriescalc.practice.service;

import com.caloriescalc.practice.dto.DishDTO;
import com.caloriescalc.practice.dto.DishesDTO;
import com.caloriescalc.practice.request.RequestDish;
import com.caloriescalc.practice.request.RequestDishes;

public interface IRestaurantService {
    DishDTO getData(RequestDish requestDish);
    DishesDTO getMultipleDishes(RequestDishes dishes);
}
