package meli.bootcamp.spring.learning.dto.ej6;

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
