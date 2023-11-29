package meli.bootcamp.ej2.participante;

import meli.bootcamp.ej2.categoria.Categoria;
import meli.bootcamp.ej2.inscripcion.Inscripcion;

public class Participante {
  private Integer numero;
  private static int contadorId = 0;
  private String dni;
  private String nombre;
  private String apellido;
  private Integer edad;
  private String celular;
  private String numeroEmergencia;
  private String grupoSanguineo;
  private Inscripcion inscripcion;

  public Participante(String dni, String nombre, String apellido, Integer edad, String celular, String numeroEmergencia,
      String grupoSanguineo) {
    this.numero = ++contadorId;
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.celular = celular;
    this.numeroEmergencia = numeroEmergencia;
    this.grupoSanguineo = grupoSanguineo;
  }

  public Integer getEdad() {
    return this.edad;
  }

  public void setInscripcion(Inscripcion inscripcion) {
    this.inscripcion = inscripcion;
  }

  public void desinscribir() {
    Categoria categoria = inscripcion.getCategoria();
    categoria.quitarInscripcion(this.inscripcion);
    this.inscripcion = null;
  }

  public String getNombre() {
    return this.nombre + " " + this.apellido;
  }

  public Integer getNumero() {
    return numero;
  }

  public String getDni() {
    return dni;
  }

  public String getCelular() {
    return celular;
  }

  public String getNumeroEmergencia() {
    return numeroEmergencia;
  }

  public String getGrupoSanguineo() {
    return grupoSanguineo;
  }
}
