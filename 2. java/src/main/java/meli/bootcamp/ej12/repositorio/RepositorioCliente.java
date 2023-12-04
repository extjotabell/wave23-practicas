package meli.bootcamp.ej12.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import meli.bootcamp.ej12.cliente.Cliente;

public class RepositorioCliente {
  private static List<Cliente> clientes = new ArrayList<Cliente>();

  public static Cliente clientePorId(String idCliente) {
    Optional<Cliente> posibleCliente = clientes.stream().filter(cli -> cli.getId().equals(idCliente)).findFirst();
    if (posibleCliente.isPresent()) {
      return posibleCliente.get();
    }
    return null;
  }

  public static void agregarCliente(Cliente cliente) {
    clientes.add(cliente);
  }
}
