package meli.bootcamp.ej2.inscripcion;

import meli.bootcamp.ej2.categoria.Categoria;
import meli.bootcamp.ej2.participante.Participante;

public class Inscripcion {
  private static int contadorId = 0;
  private Integer numero;
  private Categoria categoria;
  private Participante participante;
  private Double monto;

  public Inscripcion(Categoria categoria, Participante participante) {
    this.numero = ++contadorId;
    this.categoria = categoria;
    this.participante = participante;
    this.monto = categoria.montoSegunEdad(participante.getEdad());
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Double getMonto() {
    return monto;
  }

  @Override
  public String toString() {
    return "Inscripcion #" + this.numero + ": " + participante.getNombre() + " en categoria "
        + categoria.getNombre();
  }

}
