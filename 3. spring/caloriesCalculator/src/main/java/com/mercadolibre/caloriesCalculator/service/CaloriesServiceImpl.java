package com.mercadolibre.caloriesCalculator.service;

import com.mercadolibre.caloriesCalculator.dto.DishesDTO;
import com.mercadolibre.caloriesCalculator.dto.DishesWeightDto;
import com.mercadolibre.caloriesCalculator.entity.Ingredients;
import com.mercadolibre.caloriesCalculator.repository.IIngredientsRepository;
import com.mercadolibre.caloriesCalculator.repository.IngredientsRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CaloriesServiceImpl implements ICaloriesService {
    IIngredientsRepository caloriesRepository;

    public CaloriesServiceImpl(IngredientsRepositoryImpl caloriesRepository) {
        this.caloriesRepository = caloriesRepository;
    }
    @Override
    public List<DishesDTO> getAllDishes() {
        Map<String, List<Ingredients>> dishesMap = createDishDto();
        List<DishesDTO> dishesList = new ArrayList<>();
        for (Map.Entry<String, List<Ingredients>> entry : dishesMap.entrySet()) {
            String nameDish = entry.getKey();
            List<Ingredients> ingredients = entry.getValue();
            dishesList.add(new DishesDTO(nameDish, ingredients, null, 0));
        }
        return dishesList;
    }

        @Override
        public Map<String, List<Ingredients>> createDishDto() {

            Map<String, List<Ingredients>> dishesMap = new HashMap<>();

            List<Ingredients> allIngredients = caloriesRepository.getAllIngredients();

            List<Ingredients> ensaladaDelChef = new ArrayList<>();
            ensaladaDelChef.add(new Ingredients("Lechuga", 18));
            ensaladaDelChef.add(new Ingredients("Tomates", 22));
            ensaladaDelChef.add(new Ingredients("Zanahoria", 42));
            ensaladaDelChef.add(new Ingredients("Cebolla", 47));

            List<Ingredients> pizza = new ArrayList<>();
            pizza.add(new Ingredients("Champiñón y otras setas", 28));
            pizza.add(new Ingredients("Harina de trigo refinada", 353));
            pizza.add(new Ingredients("Salsa de tomate en conserva", 86));
            pizza.add(new Ingredients("Queso mozzarella", 245));
            pizza.add(new Ingredients("Salchichón", 294));

            List<Ingredients> arrozConPollo = new ArrayList<>();
            arrozConPollo.add(new Ingredients("Pollo, Muslo", 186));
            arrozConPollo.add(new Ingredients("Arroz blanco", 354));
            arrozConPollo.add(new Ingredients("Pimiento", 22));
            arrozConPollo.add(new Ingredients("Cebolla", 47));
            arrozConPollo.add(new Ingredients("Ajos", 169));
            arrozConPollo.add(new Ingredients("Agua ardiente", 280));

            // Verificar ingredientes
            verifyIngredients(ensaladaDelChef, allIngredients);
            verifyIngredients(pizza, allIngredients);
            verifyIngredients(arrozConPollo, allIngredients);

            // Añadir platos al mapa
            dishesMap.put("Ensalada del Chef", ensaladaDelChef);
            dishesMap.put("Pizza", pizza);
            dishesMap.put("Arroz con Pollo", arrozConPollo);

            return dishesMap;
        }

        private void verifyIngredients(List<Ingredients> dishIngredients, List<Ingredients> allIngredients) {
            for (Ingredients ingredient : dishIngredients) {
                boolean exists = allIngredients.stream()
                        .anyMatch(i -> i.getName()
                                .equals(ingredient.getName())
                                && i.getCalories() == ingredient.getCalories());
                if (!exists) {
                    throw new RuntimeException("Ingredient " + ingredient.getName() + " with calories "
                            + ingredient.getCalories() + " does not exist in the repository");
                }
            }
        }

        @Override
        public DishesDTO calculateDishCalories(String nameDish, int weight) {
            Map<String, List<Ingredients>> dishesMap = createDishDto();
            String lowerCaseNameDish = nameDish.toLowerCase();
            List<Ingredients> ingredients = null;
            for (Map.Entry<String, List<Ingredients>> entry : dishesMap.entrySet()) {
                if (entry.getKey().toLowerCase().equals(lowerCaseNameDish)) {
                    ingredients = entry.getValue();
                    break;
                }
            }
            if (ingredients == null) {
                throw new RuntimeException("Dish " + nameDish + " does not exist in the repository");
            }
            int totalCalories = 0;
            Ingredients ingredientWithMostCalories = null;
            for (Ingredients ingredient : ingredients) {
                totalCalories += ingredient.getCalories();
                if (ingredientWithMostCalories == null || ingredient.getCalories() > ingredientWithMostCalories.getCalories()) {
                    ingredientWithMostCalories = ingredient;
                }
            }
            int totalCaloriesBasedOnWeight = totalCalories * weight / 100;
            return new DishesDTO(nameDish, ingredients, ingredientWithMostCalories, totalCaloriesBasedOnWeight);
        }

    @Override
    public List<DishesDTO> calculateDishCaloriesList(List<DishesWeightDto> dishesDto) {
        List<DishesDTO> dishesDtoList = new ArrayList<>();
        for (DishesWeightDto dish : dishesDto) {
            DishesDTO calculatedDish = calculateDishCalories(dish.getNameDishes(), dish.getWeight());
            dishesDtoList.add(calculatedDish);
        }
        return dishesDtoList;
    }
}



