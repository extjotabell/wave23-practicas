package meli.bootcamp.ej11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import meli.bootcamp.ej11.cliente.Cliente;
import meli.bootcamp.ej11.factura.Factura;
import meli.bootcamp.ej11.factura.ItemFactura;
import meli.bootcamp.ej11.repositorio.RepositorioCliente;

/**
 * Ejercicio 11: Supermercado “El Económico”
 */
public class Ej11Java {

  public static void main(String[] args) {
    Cliente cli1 = new Cliente("11222333", "Tiago Ramirez");
    RepositorioCliente.agregarCliente(cli1);
    Cliente cli2 = new Cliente("44555666", "Julian Alvarez");
    RepositorioCliente.agregarCliente(cli2);
    Cliente cli3 = new Cliente("77888999", "Lionel Messi");
    RepositorioCliente.agregarCliente(cli3);
    System.out.println("-----------------Todos-----------------");
    RepositorioCliente.mostrarTodos();
    System.out.println("-----------------Removido 1-----------------");
    RepositorioCliente.quitar(cli2);
    RepositorioCliente.mostrarTodos();

    System.out.println("-----------------Encontrar cliente-----------------");
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingresa un dni para buscar: ");
    
    Cliente clienteEncontrado = RepositorioCliente.buscarClientePorDni(scanner.nextLine());
    
    if (clienteEncontrado == null) {
      System.out.println("No se encontro el cliente");
    } else {
      System.out.print("Cliente encontrado: ");
      System.out.println(clienteEncontrado);
    }
    
    System.out.println("-----------------Factura nueva-----------------");
    Factura f1 = new Factura("00111222");
    ItemFactura itf1 = new ItemFactura("1", "Chocolate rico", 2, 100.0);
    ItemFactura itf2 = new ItemFactura("2", "Pizza chica", 1, 100.0);
    List<ItemFactura> items1 = new ArrayList<ItemFactura>();
    items1.add(itf1);
    items1.add(itf2);
    f1.agregarItems(items1);

    System.out.println(f1);
    scanner.close();
  }
}