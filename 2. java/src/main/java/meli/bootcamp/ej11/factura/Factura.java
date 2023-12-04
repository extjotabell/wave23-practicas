package meli.bootcamp.ej11.factura;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import meli.bootcamp.ej11.cliente.Cliente;
import meli.bootcamp.ej11.repositorio.RepositorioCliente;

public class Factura {
  private LocalDateTime fecha;
  private String clienteDni;
  private List<ItemFactura> items;
  private Double total;

  public Factura(String clienteDni) {
    this.clienteDni = clienteDni;
    this.fecha = LocalDateTime.now();
    this.items = new ArrayList<ItemFactura>();
    this.total = 0.0;
    if (RepositorioCliente.buscarClientePorDni(clienteDni) == null) {
      Cliente clienteNuevo = new Cliente(clienteDni, "");
      RepositorioCliente.agregarCliente(clienteNuevo);
    }
  }

  public void agregarItems(List<ItemFactura> items) {
    this.items = items;
    this.calcularTotal();
  }

  private void calcularTotal() {
    this.total = items.stream().mapToDouble(item -> item.getCantidad() * item.getCostoUnitario()).sum();
  }

  @Override
  public String toString() {
    return "Factura [fecha=" + fecha + ", clienteDni=" + clienteDni + ", items=" + items + ", total=" + total + "]";
  }

}
