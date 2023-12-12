package meli.bootcamp.spring.learning.ej9.dto.request;

import lombok.Getter;

@Getter
public class PlatoRequestDto {
  private String nombre;
  private Integer gramos;

  public PlatoRequestDto(String nombre, Integer gramos) {
    this.nombre = nombre;
    this.gramos = gramos;
  }

}
