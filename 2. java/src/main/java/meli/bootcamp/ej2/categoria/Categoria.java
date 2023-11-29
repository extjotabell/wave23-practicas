package meli.bootcamp.ej2.categoria;

import java.util.HashSet;
import java.util.Set;

import meli.bootcamp.ej2.inscripcion.Inscripcion;
import meli.bootcamp.ej2.participante.Participante;

public class Categoria {
  private Integer id;

  private static int contadorId = 0;
  private String nombre;
  private String descripcion;

  private Double precioMayores;
  private Double precioMenores;
  private Boolean aceptaMenores;
  private Set<Inscripcion> inscripciones;

  public Categoria(String nombre, String descripcion, Double precioMayores, Double precioMenores,
      Boolean aceptaMenores) {
    this.id = ++contadorId;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precioMayores = precioMayores;
    this.precioMenores = precioMenores;
    this.aceptaMenores = aceptaMenores;
    inscripciones = new HashSet<Inscripcion>();
  }

  private boolean estaHabilitado(Integer edad) {
    return edad >= 18 || this.aceptaMenores;
  }

  public Double montoSegunEdad(Integer edad) {
    if (edad >= 18) {
      return precioMayores;
    }
    return precioMenores;
  }

  public void inscribir(Participante participante) {
    if (estaHabilitado(participante.getEdad())) {
      Inscripcion inscripcion = new Inscripcion(this, participante);
      participante.setInscripcion(inscripcion);
      this.inscripciones.add(inscripcion);
    } else {
      System.out.println("La persona no se puede inscribir ya que es menor de edad");
    }
  }

  public void quitarInscripcion(Inscripcion inscripcion) {
    this.inscripciones.remove(inscripcion);
  }

  public Double totalRecaudado() {
    return this.inscripciones.stream().mapToDouble(inscripcion -> inscripcion.getMonto()).sum();
  }

  public Set<Inscripcion> getInscripciones() {
    return inscripciones;
  }

  public String getNombre() {
    return nombre;
  }

  public Integer getId() {
    return id;
  }

  public String getDescripcion() {
    return descripcion;
  }
}
