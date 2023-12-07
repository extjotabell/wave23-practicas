package meli.bootcamp.spring.learning.dto.ej7;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class PersonaDto implements Serializable {
  private String nombre;
  private String apellido;

  public PersonaDto(String nombre, String apellido) {
    this.nombre = nombre;
    this.apellido = apellido;
  }

}
