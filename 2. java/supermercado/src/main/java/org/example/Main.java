package org.example;

import org.example.entities.Cliente;
import org.example.entities.Supermercado;

public class Main {
    public static void main(String[] args) {

        Supermercado.crearCliente(new Cliente(12345671, "Jorge", "Lopez"));
        Supermercado.crearCliente(new Cliente(12345671, "Jorge", "Lopez"));
        Supermercado.crearCliente(new Cliente(12345672, "Diego", "Fernandez"));
        Supermercado.crearCliente(new Cliente(12345673, "Juan", "Perez"));
        Supermercado.listarClientes();

        Supermercado.eliminarCliente(new Cliente(12345671, "Jorge", "Lopez"));
        Supermercado.listarClientes();

        Supermercado.buscarCliente();
    }
}