package meli.bootcamp.spring.learning.ej8.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Personaje {
  private String name;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;

  public Personaje() {
  }

  public Personaje(String name, Integer height, Integer mass, String hair_color, String skin_color, String eye_color,
      String birth_year, String gender, String homeworld, String species) {
    this.name = name;
    this.height = height;
    this.mass = mass;
    this.hair_color = hair_color;
    this.skin_color = skin_color;
    this.eye_color = eye_color;
    this.birth_year = birth_year;
    this.gender = gender;
    this.homeworld = homeworld;
    this.species = species;
  }

}
