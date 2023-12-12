package com.example.calculadoracalorias.dto;

public class IngredienteDTO{
    private String name;
    private int calories;

    public IngredienteDTO(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public IngredienteDTO(String name) {
        this.name = name;
    }

    public IngredienteDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
