package meli.bootcamp.spring.learning.ej7.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Persona {
  private String id;
  private String nombre;
  private String apellido;
  private Integer edad;
  List<Sintoma> sintomas;

  public Persona(String id, String nombre, String apellido, Integer edad) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.sintomas = new ArrayList<Sintoma>();
  }

  public void agregarSintoma(Sintoma sintoma) {
    this.sintomas.add(sintoma);
  }
}
