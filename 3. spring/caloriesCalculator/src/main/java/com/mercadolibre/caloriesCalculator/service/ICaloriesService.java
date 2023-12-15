package com.mercadolibre.caloriesCalculator.service;

import com.mercadolibre.caloriesCalculator.dto.DishesDTO;
import com.mercadolibre.caloriesCalculator.dto.DishesWeightDto;
import com.mercadolibre.caloriesCalculator.entity.Ingredients;

import java.util.List;
import java.util.Map;

public interface ICaloriesService {
    public Map<String, List<Ingredients>> createDishDto();
    public DishesDTO calculateDishCalories(String nameDish, int weight);

    List<DishesDTO> calculateDishCaloriesList(List<DishesWeightDto> dishesDto);

    List<DishesDTO> getAllDishes();

}
