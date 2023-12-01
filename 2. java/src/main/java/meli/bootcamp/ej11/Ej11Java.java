package meli.bootcamp.ej11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import meli.bootcamp.ej11.cliente.Cliente;

/**
 * Ejercicio 11: Supermercado “El Económico”
 */
public class Ej11Java {
  private static List<Cliente> clientes = new ArrayList<Cliente>();

  public static void main(String[] args) {
    Cliente cli1 = new Cliente("11222333", "Tiago Ramirez");
    clientes.add(cli1);
    Cliente cli2 = new Cliente("44555666", "Julian Alvarez");
    clientes.add(cli2);
    Cliente cli3 = new Cliente("77888999", "Lionel Messi");
    clientes.add(cli3);
    System.out.println("-----------------Todos-----------------");
    clientes.forEach(System.out::println);
    System.out.println("-----------------Removido 1-----------------");
    clientes.remove(cli2);
    clientes.forEach(System.out::println);
    
    System.out.println("-----------------Encontrar cliente-----------------");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingresa un dni para buscar: ");
    
    Cliente clienteEncontrado = buscarClientePorDni(scanner.nextLine());

    if (clienteEncontrado == null) {
      System.out.println("No se encontro el cliente");
    } else {
      System.out.print("Cliente encontrado: ");
      System.out.println(clienteEncontrado);
    }

    scanner.close();
  }

  private static Cliente buscarClientePorDni(String dni) {
    Optional<Cliente> posibleCliente = clientes.stream()
        .filter(cli -> cli.getDni().equals(dni))
        .findFirst();
    if (posibleCliente.isPresent()) {
      return posibleCliente.get();
    }
    return null;
  }
}