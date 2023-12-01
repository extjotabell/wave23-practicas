package meli.bootcamp.ej7.persona;

import java.util.ArrayList;
import java.util.List;

public class Persona {
  private String nombreCompleto;
  private String descripcion;
  private List<String> habilidades;

  public Persona(String nombreCompleto, String descripcion) {
    this.nombreCompleto = nombreCompleto;
    this.descripcion = descripcion;
    this.habilidades = new ArrayList<String>();
  }

  @Override
  public String toString() {
    String habilidadesSeparadas = "[";
    for (String habilidad : this.habilidades) {
      habilidadesSeparadas = habilidadesSeparadas + ", " + habilidad;
    }
    habilidadesSeparadas = habilidadesSeparadas + "]";
    habilidadesSeparadas = habilidadesSeparadas.replace("[, ", "[");
    return "Nombre= " + nombreCompleto + ", descripcion= " + descripcion + ", habilidades= " + habilidadesSeparadas;
  }

  public void agregarHabilidad(String habilidad) {
    this.habilidades.add(habilidad);
  }

}
