package com.meli.foodapi.service;

import com.meli.foodapi.dto.Request.DishEntryDTO;
import com.meli.foodapi.dto.Response.DishDTO;
import com.meli.foodapi.entity.Dish;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface IFoodService {

    List<DishDTO> getAll();

    DishDTO findDish(String name, int weight);

    List<DishDTO> findDishes(List<DishEntryDTO> entrydishes);
}
