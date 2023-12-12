package meli.bootcamp.spring.learning.ej9.dto.response;

import lombok.Getter;

@Getter
public class IngredienteResponseDto {
  private String name;
  private Integer calories;

  public IngredienteResponseDto(String name, Integer calories) {
    this.name = name;
    this.calories = calories;
  }

}
