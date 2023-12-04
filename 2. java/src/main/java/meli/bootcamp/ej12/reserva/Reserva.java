package meli.bootcamp.ej12.reserva;

public class Reserva {
  private String descripcion;
  private Double precio;
  private TipoReserva tipo;

  public Reserva(String descripcion, Double precio, TipoReserva tipo) {
    this.descripcion = descripcion;
    this.precio = precio;
    this.tipo = tipo;
  }

  public Double getPrecio() {
    return this.precio;
  }

  public Double getPrecio(Double descuento) {
    Double dto = 1 - (descuento / 100);
    return this.precio * dto;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public TipoReserva getTipo() {
    return this.tipo;
  }

  @Override
  public String toString() {
    return descripcion + "(" + tipo + ")";
  }
  
}
