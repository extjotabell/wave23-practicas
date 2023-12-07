package meli.bootcamp.spring.learning.entities.ej6;

import lombok.Getter;

@Getter
public class Persona {
  private String nombre;
  private String apellido;
  private Integer edad;
  private Deporte deporte;

  public Persona(String nombre, String apellido, Integer edad, Deporte deporte) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.deporte = deporte;
  }

}
