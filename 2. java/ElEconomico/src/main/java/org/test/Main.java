package org.test;

import org.bootcamp.Cliente;
import org.bootcamp.Factura;
import org.bootcamp.Item;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Cliente lucas = new Cliente(23857839L, "Lucas", "Salerno");
        Cliente martin = new Cliente(32758923L, "Martin", "Perez");
        Cliente maria = new Cliente(28431972L, "Maria", "Fernandez");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(lucas);
        clientes.add(martin);
        clientes.add(maria);

        System.out.println("Lista Original");
        clientes.forEach(System.out::println);

        System.out.println();
        //System.out.println("Lista modificada. Cliente eliminado");
        //clientes.remove(1);

        //clientes.forEach(System.out::println);

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese DNI de la persona a buscar: ");
        Long dni = scanner.nextLong();

        Cliente cliente = clientes.stream().filter(p -> dni.equals(p.getDni())).findAny().orElse(null);
        if (cliente != null){
            System.out.println(cliente);
        }
        else{
            System.out.println("No se ha encontrado el cliente solicitado");
        }
        */


        // Lista de Items
        List<Item> items = new ArrayList<>();
        items.add(new Item(12345L, 3, "Fideos", 1000D));
        items.add(new Item(23456L, 5, "Manzana", 150));
        items.add(new Item(45318L, 2, "Yerba", 1300));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese DNI de la persona a agregar a la factura: ");
        Long dni = scanner.nextLong();

        Cliente cliente = clientes.stream().filter(p -> dni.equals(p.getDni())).findAny().orElse(null);
        if (cliente == null){
            System.out.println("El cliente no existe. Debe ser agregado.");
            System.out.print("Ingrese nombre del cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese apellido del cliente: ");
            String apellido = scanner.nextLine();
            clientes.add(new Cliente(dni, nombre, apellido));

            cliente = clientes.stream().filter(p -> dni.equals(p.getDni())).findAny().orElse(null);
        }

        Double total = 0D;

        for(Item item : items){
            total += item.getPrecio_unitario() + item.getCantidad();
        }

        Factura factura = new Factura(1L, cliente, items, total);
        System.out.println("Factura Creada.");
        System.out.println(factura);
    }

}
