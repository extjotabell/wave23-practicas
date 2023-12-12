package com.spring.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ingredient {
    private Food food;
    private Double weight;

}
