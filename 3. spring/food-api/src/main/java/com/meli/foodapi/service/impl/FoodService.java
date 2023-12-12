package com.meli.foodapi.service.impl;


import com.meli.foodapi.dto.Request.DishEntryDTO;
import com.meli.foodapi.dto.Response.DishDTO;
import com.meli.foodapi.dto.Response.IngredientDTO;
import com.meli.foodapi.entity.Dish;
import com.meli.foodapi.mapper.DishMapper;
import com.meli.foodapi.repository.IFoodRepository;
import com.meli.foodapi.service.IFoodService;
import com.meli.foodapi.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FoodService  implements IFoodService {

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
    public List<DishDTO> findDishes(List<DishEntryDTO> entrydishes) {
        List<DishDTO> dishes = new ArrayList<>();
        entrydishes.forEach(d -> dishes.add(findDish(d.getName(), d.getWeight())));
        return dishes;
    }

}
