package com.spring.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlatoDto {
    private int totalCalorias;
    private List<IngredienteDTO> ingredientes;
    private String ingredienteMayorCaloria;
}
