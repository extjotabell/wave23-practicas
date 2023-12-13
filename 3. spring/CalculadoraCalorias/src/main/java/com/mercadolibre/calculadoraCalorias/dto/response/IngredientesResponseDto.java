package com.mercadolibre.calculadoraCalorias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class IngredientesResponseDto {
    List<IngredienteResponseDto> ingredientes;
}
