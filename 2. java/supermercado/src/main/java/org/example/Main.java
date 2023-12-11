package org.example;

import org.example.CRUD.ClienteCRUD;
import org.example.CRUD.FacturaCRUD;
import org.example.CRUD.ItemCRUD;
import org.example.entities.Cliente;
import org.example.entities.Factura;
import org.example.entities.Item;

import java.util.List;

public class Main {
    static final FacturaCRUD facturaCRUD = new FacturaCRUD();
    static final ClienteCRUD clienteCRUD = new ClienteCRUD();
    static final ItemCRUD itemCRUD = new ItemCRUD();

    public static void main(String[] args) {
        // Se crean 3 clientes random
        Cliente cliente1 = clienteCRUD.create(new Cliente(12345671L, "Jorge", "Lopez"));
        Cliente cliente2 = clienteCRUD.create(new Cliente(12345674L, "Juan", "Perez"));
        Cliente cliente3 = clienteCRUD.create(new Cliente(12345672L, "Diego", "Fernandez"));

        // Listamos los clientes por pantalla
        listarClientes();

        // Eliminamos un cliente y volvemos a listar para comprobar la correcta eliminación
        clienteCRUD.delete(cliente1);
        listarClientes();

        // Creamos una factura para el cliente2
        crearFactura(cliente2);
    }

    /**
     * Método para listar por consola los clientes
     */
    private static void listarClientes() {
        System.out.println("\nListando clientes:");
        clienteCRUD.findAll().forEach(System.out::println);
    }

    /**
     * Método para crear una factura, validando previamente la existencia del cliente
     * @param cliente
     */
    private static void crearFactura(Cliente cliente) {
        clienteCRUD.validarCliente(cliente);

        Factura factura = new Factura(1L, cliente, List.of(
                itemCRUD.create(new Item(1L, "Yerba Verdeflor", 2, 231.56)),
                itemCRUD.create(new Item(4L, "Yerba Amanda", 10, 200.00))
        ));

        facturaCRUD.create(factura);
    }
}