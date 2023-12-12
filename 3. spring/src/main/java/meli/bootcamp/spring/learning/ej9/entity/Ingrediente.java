package meli.bootcamp.spring.learning.ej9.entity;

import lombok.Getter;

@Getter
public class Ingrediente {
  private String name;
  private Integer calories;

  public Ingrediente() {
  }

  public Ingrediente(String name, Integer calories) {
    this.name = name;
    this.calories = calories;
  }

}
