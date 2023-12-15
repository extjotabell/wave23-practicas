package com.mercadolibre.caloriesCalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class IngredientsDTO {
    private String name;
    private int calories;

}
