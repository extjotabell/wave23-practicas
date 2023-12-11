package meli.bootcamp.spring.learning.ej7.entity;

import lombok.Getter;

@Getter
public class Sintoma {
  private String codigo;
  private String nombre;
  private NivelGravedad gravedad;

  public Sintoma(String codigo, String nombre, NivelGravedad gravedad) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.gravedad = gravedad;
  }
}
