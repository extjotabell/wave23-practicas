package meli.bootcamp.ej11.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import meli.bootcamp.ej11.cliente.Cliente;

public class RepositorioCliente {
  private static List<Cliente> clientes = new ArrayList<Cliente>();

  public static void agregarCliente(Cliente cliente) {
    clientes.add(cliente);
  }

  public static Cliente buscarClientePorDni(String dni) {
    Optional<Cliente> posibleCliente = clientes.stream()
        .filter(cli -> cli.getDni().equals(dni))
        .findFirst();
    if (posibleCliente.isPresent()) {
      return posibleCliente.get();
    }
    return null;
  }

  public static void mostrarTodos(){
    clientes.forEach(System.out::println);
  }

  public static void quitar(Cliente cli2) {
    clientes.remove(cli2);
  }
}
