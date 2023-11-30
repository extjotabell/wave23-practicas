package meli.bootcamp.ej5.distribuidora;

import java.util.ArrayList;
import java.util.List;

import meli.bootcamp.ej5.producto.NoPerecedero;
import meli.bootcamp.ej5.producto.Perecedero;
import meli.bootcamp.ej5.producto.Producto;

public class Distribuidora {
  List<Producto> productos;

  public Distribuidora() {
    this.productos = new ArrayList<Producto>();
    productos.add(new Perecedero("Leche", 461.23, 10));
    productos.add(new Perecedero("Coca Retornable", 540.0, 3));
    productos.add(new NoPerecedero("Arroz", 892.00, "Arroces"));
    productos.add(new NoPerecedero("Harina 0000", 2140.00, "Harinas"));
    productos.add(new NoPerecedero("Bolsa de papas", 3000.00, "Papas"));
  }

  public double calcularTotalProductos() {
    return this.productos.stream().mapToDouble(prod -> prod.calcular(1)).sum();
  }

}
