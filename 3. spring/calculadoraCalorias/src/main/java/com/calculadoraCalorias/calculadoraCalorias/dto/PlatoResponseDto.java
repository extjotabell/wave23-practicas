package com.calculadoraCalorias.calculadoraCalorias.dto;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Builder
public class PlatoResponseDto{
    private String name;
    private int weight;
    private List<IngredienteDto> ingredients;
    private IngredienteDto hightIngredient;
}
