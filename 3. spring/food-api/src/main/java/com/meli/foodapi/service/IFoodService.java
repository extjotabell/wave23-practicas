package com.meli.foodapi.service;

import com.meli.foodapi.dto.Request.DishEntryDTO;
import com.meli.foodapi.dto.Response.DishDTO;

import java.util.List;

public interface IFoodService {

    DishDTO findDish(String name, int weight);

    List<DishDTO> findDishes(List<DishEntryDTO> entrydishes);
}
