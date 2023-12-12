package org.ejercicio.restaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();
}
