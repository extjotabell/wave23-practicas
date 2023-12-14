package com.caloriescalc.practice.dto;

import com.caloriescalc.practice.entity.Ingredient;
import java.util.ArrayList;

public class DishDTO {
    private String name;
    private int totalCalories;
    private ArrayList<Ingredient> ingredients;
    private Ingredient ingredientWithMostCalories;

    public DishDTO() {
    }

    public DishDTO(String name, int totalCalories, ArrayList<Ingredient> ingredients, Ingredient ingredientWithMostCalories) {
        this.name = name;
        this.totalCalories = totalCalories;
        this.ingredients = ingredients;
        this.ingredientWithMostCalories = ingredientWithMostCalories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getIngredientWithMostCalories() {
        return ingredientWithMostCalories;
    }

    public void setIngredientWithMostCalories(Ingredient ingredientWithMostCalories) {
        this.ingredientWithMostCalories = ingredientWithMostCalories;
    }

    @Override
    public String toString() {
        return "DishDTO{" +
                "name='" + name + '\'' +
                ", totalCalories=" + totalCalories +
                ", ingredients=" + ingredients +
                ", ingredientWithMostCalories=" + ingredientWithMostCalories +
                '}';
    }
}
