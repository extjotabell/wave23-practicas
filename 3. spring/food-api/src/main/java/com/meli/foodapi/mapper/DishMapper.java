package com.meli.foodapi.mapper;

import com.meli.foodapi.dto.Response.DishDTO;
import com.meli.foodapi.dto.Response.IngredientDTO;
import com.meli.foodapi.entity.Dish;

import java.util.Comparator;
import java.util.List;

public class DishMapper {
    public static DishDTO dishDTOToDish(Dish dish){
        List<IngredientDTO> ingredients = dish.getIngredients().stream()
                                               .map(i -> new IngredientDTO(i.getName(), i.getCalories())).toList();
        
        DishDTO dishDTO = new DishDTO(dish.getName(), 0, ingredients,
                                ingredients.stream().max(Comparator.comparingInt(IngredientDTO::getCalories)).get());
        return dishDTO;
    }
}
