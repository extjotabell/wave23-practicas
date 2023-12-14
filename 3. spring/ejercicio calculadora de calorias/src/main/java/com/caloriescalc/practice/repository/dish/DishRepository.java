package com.caloriescalc.practice.repository.dish;

import com.caloriescalc.practice.entity.Dish;
import com.caloriescalc.practice.entity.Ingredient;
import com.caloriescalc.practice.repository.food.FoodRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository implements  IDishRepository {
    private final FoodRepository fr;
    private List<Dish> dishes = new ArrayList<>();
    List<Ingredient> ingredients;

    public DishRepository(FoodRepository fr) {
        this.fr = fr;
    }

    @Override
    public List<Dish> getAll() {
        return dishes;
    }

    @Override
    public Dish getByName(String name) {
        return dishes.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }

    @PostConstruct
    public void init(){
        try {
            ingredients = getIngredients();
        } catch (Exception e) {
            System.err.println("Error intializing ingredients: " + e.getMessage());
            ingredients = new ArrayList<>();
        }
        Ingredient chicken = getIngredientByName(ingredients, "Pollo");
        Ingredient potatos = getIngredientByName(ingredients, "Papas cocidas");
        Ingredient tomatoSauce = getIngredientByName(ingredients, "Salsa de tomate en conserva");
        if (chicken != null && potatos != null && tomatoSauce != null) {
            dishes.add(new Dish("Milanesa con papas fritas", new ArrayList<>(List.of(chicken, potatos, tomatoSauce))));
        }

        Ingredient lettuce = getIngredientByName(ingredients, "Lechuga");
        Ingredient tomato = getIngredientByName(ingredients, "Tomates");
        Ingredient onion = getIngredientByName(ingredients, "Cebolla");
        Ingredient carrot = getIngredientByName(ingredients, "Zanahoria");
        if (lettuce != null && tomato != null && onion != null && carrot != null)
            dishes.add(new Dish("Ensalada del chef", new ArrayList<>(List.of(lettuce, tomato, onion, carrot))));


        Ingredient mayonnaise = getIngredientByName(ingredients, "Mayonesa");
        Ingredient hamburger = getIngredientByName(ingredients, "Hamburguesa");
        Ingredient ryeBread = getIngredientByName(ingredients, "Pan de centeno");
        if (mayonnaise != null && hamburger != null && ryeBread != null && tomato != null)
            dishes.add(new Dish("Hamburguesa pan centeno", new ArrayList<>(List.of(mayonnaise, tomato, hamburger, ryeBread))));

        Ingredient mushroom = getIngredientByName(ingredients, "Champiñón y otras setas");
        Ingredient flour = getIngredientByName(ingredients, "Harina de trigo integral");
        Ingredient cheese = getIngredientByName(ingredients, "Queso mozzarella");
        Ingredient salchichon = getIngredientByName(ingredients, "Salchichón");
        if (mushroom != null && tomatoSauce != null && flour != null && cheese != null && salchichon != null)
            dishes.add(new Dish("Pizza", new ArrayList<>(List.of(mushroom, tomatoSauce, flour, cheese, salchichon))));
    }

    private Ingredient getIngredientByName(List<Ingredient> ingredients, String name) {
        for (Ingredient i : ingredients) {
            if (i.getName().equals(name)) {
                return i;
            }
        }

        return null;
    }

    private List<Ingredient> getIngredients() {
        return fr.getAll();
    }
}
