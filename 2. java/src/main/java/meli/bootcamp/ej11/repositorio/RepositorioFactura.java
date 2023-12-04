package meli.bootcamp.ej11.repositorio;

import java.util.ArrayList;
import java.util.List;

import meli.bootcamp.ej11.factura.Factura;

public class RepositorioFactura {
  private static List<Factura> facturas = new ArrayList<Factura>();

  public static void agregarFactura(Factura factura) {
    facturas.add(factura);
  }
}
