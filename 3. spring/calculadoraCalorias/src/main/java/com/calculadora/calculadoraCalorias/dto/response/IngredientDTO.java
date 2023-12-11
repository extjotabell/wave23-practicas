package com.calculadora.calculadoraCalorias.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class IngredientDTO {
    private String name;
    private int calories;
}
