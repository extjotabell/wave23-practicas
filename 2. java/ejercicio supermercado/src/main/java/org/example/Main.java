package org.example;

import org.example.repos.ImplementacionCliente;
import org.example.repos.ImplementacionFactura;
import org.example.repos.ImplementacionItem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ImplementacionCliente impClientes = new ImplementacionCliente();
        ImplementacionItem impItems = new ImplementacionItem();
        ImplementacionFactura impFactura = new ImplementacionFactura();

        // Dos
        Cliente clienteUno = new Cliente(123L, "Ana", "Lopez");
        Cliente clienteDos = new Cliente(1234L, "Sol", "Martinez");
        Cliente clienteTres = new Cliente(12345L, "Maria", "Gonzalez");
        Cliente clienteCuatro = new Cliente(123456L, "Jose", "Perez");
        impClientes.guardar(clienteUno);
        impClientes.guardar(clienteDos);
        impClientes.guardar(clienteTres);
        //impClientes.guardar(clienteCuatro);

        // Tres
        impClientes.mostrar();
        System.out.println("-------------------------------------------------------");

        // Cuatro
        String clienteAEliminar = "Ana";
        impClientes.buscarEliminarPorNombre(clienteAEliminar);
        System.out.println("Clientes restantes:");
        impClientes.mostrar();


        // Cinco
        /*System.out.println("Ingrese número de DNI");
        Scanner scanner = new Scanner(System.in);
        Long numDNI = scanner.nextLong();

        if (impClientes.buscar(numDNI).isPresent()) {
            impClientes.mostrar();
        } else {
            System.out.println("No se encontró cliente");
        }

        scanner.close();*/

        /////////////////////////////////// PARTE 2 //////////////////////////////////////////
        // Uno
        System.out.println("-------------------------------------------------------");
        Item itemUno = new Item("123ABC", "Jabón liquido", 2, 110);
        Item itemDos = new Item("1234ABC", "Pan Bimbo", 1, 90);
        Item itemTres = new Item("12345ABC", "Fideos", 3, 50);
        impItems.guardar(itemUno);
        impItems.guardar(itemDos);
        impItems.guardar(itemTres);
        impItems.mostrar();

        double totalCompra = 0;
        for (Item i : impItems.traerTodos()) {
            totalCompra += i.getCostoUnitario() * i.getCantidadComprada();
        }


        // Dos
        System.out.println("-------------------------------------------------------");
        if (impClientes.buscar(clienteCuatro.getDni()).isPresent()) {
            Factura nuevaFactura = new Factura(clienteCuatro, impItems.traerTodos(), totalCompra);
            impFactura.guardar(nuevaFactura);
            System.out.println("Factura de cliente existente creada con éxito");
            impFactura.mostrar();
        } else {
            Cliente nuevo = new Cliente(1234567L, "Jose", "Perez");
            impClientes.guardar(nuevo);
            Factura nuevaFactura = new Factura(nuevo, impItems.traerTodos(), totalCompra);
            impFactura.guardar(nuevaFactura);
            System.out.println("Factura de cliente nuevo creada con éxito");
            impFactura.mostrar();
        }
    }
}