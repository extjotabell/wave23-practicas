package org.ejercicio.restaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private Food food;
    private Double weight;
}
