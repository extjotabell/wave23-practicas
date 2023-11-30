package meli.bootcamp.ej5.producto;

public class Perecedero extends Producto {
  private int diasPorCaducar;

  public int getDiasPorCaducar() {
    return diasPorCaducar;
  }

  public void setDiasPorCaducar(int diasPorCaducar) {
    this.diasPorCaducar = diasPorCaducar;
  }

  public Perecedero(String nombre, Double precio, int diasPorCaducar) {
    super(nombre, precio);
    this.diasPorCaducar = diasPorCaducar;
  }

  @Override
  public String toString() {
    return "Perecedero [diasPorCaducar=" + diasPorCaducar + "]";
  }

  @Override
  public double calcular(int cantidadDeProductos) {
    double precioSinReduccion = super.calcular(cantidadDeProductos);
    if (this.diasPorCaducar <= 1) {
      return precioSinReduccion / 4;
    } else if (this.diasPorCaducar <= 2) {
      return precioSinReduccion / 3;
    } else if (this.diasPorCaducar <= 3) {
      return precioSinReduccion / 2;
    }
    return precioSinReduccion;
  }

}
