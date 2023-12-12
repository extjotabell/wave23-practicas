package meli.bootcamp.spring.learning.ej9.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Plato {
  private String nombre;
  private List<Ingrediente> ingredientes;

  public Plato() {
    this.ingredientes = new ArrayList<Ingrediente>();
  }

  public Plato(String nombre, List<Ingrediente> ingredientes) {
    this.nombre = nombre;
    this.ingredientes = ingredientes;
  }

}
