package meli.bootcamp.ej11.factura;

import java.time.LocalDateTime;
import java.util.List;

import meli.bootcamp.ej11.cliente.Cliente;

public class Factura {
  private LocalDateTime fecha;
  private Cliente cliente;
  private List<ItemFactura> items;
}
