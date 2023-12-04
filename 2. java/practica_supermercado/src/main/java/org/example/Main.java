package org.example;

import org.example.repository.RepositorioCliente;
import org.example.repository.RepositorioFactura;
import org.example.repository.RepositorioProducto;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        RepositorioCliente repositorioCliente = new RepositorioCliente();

        repositorioCliente.create(new Cliente("Miguel", "Ochoa", "10"));
        repositorioCliente.create(new Cliente("Sara", "Alvarez", "12"));
        repositorioCliente.create(new Cliente("Julian", "Perez", "14"));

        repositorioCliente.listAll();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el id de un cliente para eliminar su informacion: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        repositorioCliente.delete(id);

        repositorioCliente.listAll();

        System.out.println("Ingrese el id de un cliente para consultar su informacion: ");
        id = scanner.nextInt();

        Optional<Cliente> clienteFiltrado = repositorioCliente.read(id);

        if (clienteFiltrado.isPresent()) System.out.println(clienteFiltrado.get());
        else System.out.println("No se encontro un cliente con el DNI especificado");

        Map<Producto, Integer> productos = new HashMap<>();
        RepositorioProducto repositorioProducto = new RepositorioProducto();

        productos.put(repositorioProducto.create(new Producto("Leche", 10.60)), 5);
        productos.put(repositorioProducto.create(new Producto("Agua", 2.30)), 2);

        RepositorioFactura repositorioFactura = new RepositorioFactura();

        repositorioFactura.create(new Factura(new Cliente("Miguel", "Ochoa", "10"), productos));

        System.out.println(repositorioFactura.readNullable(1));
    }
}