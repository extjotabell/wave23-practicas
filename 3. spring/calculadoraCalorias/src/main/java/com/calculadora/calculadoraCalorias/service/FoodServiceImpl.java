package com.calculadora.calculadoraCalorias.service;

import com.calculadora.calculadoraCalorias.dto.request.DishEntryDTO;
import com.calculadora.calculadoraCalorias.dto.response.DishDTO;
import com.calculadora.calculadoraCalorias.dto.response.IngredientDTO;
import com.calculadora.calculadoraCalorias.entity.Dish;
import com.calculadora.calculadoraCalorias.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService {

    @Autowired
    IFoodRepository foodRepository;

    @Override
    public DishDTO findDish(String name, int weight) {
        Dish dish = foodRepository.getAllDishes().stream().filter(d -> d.getName().equalsIgnoreCase(name)).findFirst().get();

        List<IngredientDTO> ingredientDTOS = new ArrayList<>();
        int grams = weight / dish.getIngredients().size();

        dish.getIngredients().forEach(i -> ingredientDTOS.add(new IngredientDTO(i.getName(), grams*100/i.getCalories())));

        IngredientDTO maxIngredientDTO  = ingredientDTOS.stream()
                .max(Comparator.comparingInt(IngredientDTO::getCalories)).get();

        return new DishDTO(name, weight, ingredientDTOS, maxIngredientDTO);
    }

    @Override
    public List<DishDTO> findDishes(List<DishEntryDTO> entryDishes) {
        List<DishDTO> dishes = new ArrayList<>();
        entryDishes.forEach(d -> dishes.add(findDish(d.getName(), d.getWeight())));
        return dishes;
    }
}
