package com.mercadolibre.calculadoraCalorias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteResponseDto {
    private String name;
    private Integer calories;
}
