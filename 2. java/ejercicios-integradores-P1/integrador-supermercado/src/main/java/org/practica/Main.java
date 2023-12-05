package org.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1ra Parte
        ClienteRepositorio repoClientes = ClienteRepositorio.getInstancia();

        List<Cliente> clientes = new ArrayList<>();

        Cliente client1 = new Cliente(1234, "Camila", "Mamani");
        Cliente client2 = new Cliente(5678, "Emilia", "Lopez");
        Cliente client3 = new Cliente(1212, "Maria", "Torres");

        repoClientes.addCliente(client1);
        repoClientes.addCliente(client2);
        repoClientes.addCliente(client3);

        clientes = repoClientes.getClientes();
        clientes.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese dni del cliente a borrar:");
        String dni = scanner.next();
        Optional<Cliente> client = clientes.stream().filter(c-> String.valueOf(c.getDni()).equals(dni)).findFirst();
        if(client.isPresent()){
            repoClientes.removeCliente(client.get());
            System.out.println("Cliente Borrado correctamente.\n");
        } else {
            System.out.println("No se encontró el cliente con el dni ingresado.\n");
        }

        repoClientes.getClientes().forEach(System.out::println);


        System.out.println("Ingrese dni del cliente a buscar:");
        String dni2 = scanner.next();
        Optional<Cliente> cliente = repoClientes.getClientes().stream().filter(c-> String.valueOf(c.getDni()).equals(dni2)).findFirst();
        if(cliente.isPresent()){
            System.out.println("Cliente Encontrado: "+cliente.get()+"\n");
        } else {
            System.out.println("No se encuentra un cliente con el dni ingresado.\n");
        }

        // 2da Parte
        FacturaRepositorio repoFacturas = FacturaRepositorio.getInstancia();

        List<Item> items  = new ArrayList<>();
        items.add(new Item(1, "detergente", 2, 100));
        items.add(new Item(2, "jabón", 1, 200));

        Factura factura1 = new Factura(client1, items);

        repoFacturas.addFactura(factura1, repoClientes); //Agrego nueva factura a repositorio de facturas

        System.out.println("Total factura 1 :" + factura1.getTotalFactura());



    }
}