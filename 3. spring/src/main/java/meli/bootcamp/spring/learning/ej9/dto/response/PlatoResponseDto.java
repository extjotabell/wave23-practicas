package meli.bootcamp.spring.learning.ej9.dto.response;

import java.util.List;

import lombok.Getter;

@Getter
public class PlatoResponseDto {
  private Integer calorias;
  private List<IngredienteResponseDto> ingredientes;
  private String ingredienteMayorCaloria;

  public PlatoResponseDto(Integer calorias, List<IngredienteResponseDto> ingredientes, String ingredienteMayorCaloria) {
    this.calorias = calorias;
    this.ingredientes = ingredientes;
    this.ingredienteMayorCaloria = ingredienteMayorCaloria;
  }

}
