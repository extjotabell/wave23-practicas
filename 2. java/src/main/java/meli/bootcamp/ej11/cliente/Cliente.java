package meli.bootcamp.ej11.cliente;

public class Cliente {
  private String dni;

  private String nombre;

  public Cliente(String dni, String nombre) {
    this.dni = dni;
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "DNI: " + dni + " - Nombre: " + nombre;
  }

  public String getDni() {
    return dni;
  }

}
