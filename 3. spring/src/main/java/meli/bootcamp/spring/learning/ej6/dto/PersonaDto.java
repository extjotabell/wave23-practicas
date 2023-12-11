package meli.bootcamp.spring.learning.ej6.dto;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class PersonaDto implements Serializable {
  private String nombre;
  private String apellido;
  private String deporte;

  public PersonaDto(String nombre, String apellido, String deporte) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.deporte = deporte;
  }

}
