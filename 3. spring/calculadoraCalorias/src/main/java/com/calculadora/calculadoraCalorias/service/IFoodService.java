package com.calculadora.calculadoraCalorias.service;

import com.calculadora.calculadoraCalorias.dto.request.DishEntryDTO;
import com.calculadora.calculadoraCalorias.dto.response.DishDTO;

import java.util.List;

public interface IFoodService {
    DishDTO findDish(String name, int weight);

    List<DishDTO> findDishes(List<DishEntryDTO> entryDishes);
}
