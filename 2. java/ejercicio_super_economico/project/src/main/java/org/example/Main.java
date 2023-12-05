package org.example;

import Repository.ClienteImplementa;
import Repository.FacturaImplementa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ClienteImplementa clienteImplementa = new ClienteImplementa();
        FacturaImplementa facturaImplementa = new FacturaImplementa();

        clienteImplementa.guardar(new Cliente(123,"Martin","Lackington"));
        clienteImplementa.guardar(new Cliente(124,"Esteban","Paredes"));
        clienteImplementa.guardar(new Cliente(125,"Carlos","Major"));

        List<Item> items = new ArrayList<>();
        items.add(new Item(1,"Bebida",2,1000));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---- Menú ----");
            System.out.println("1. Recorrer la lista de clientes");
            System.out.println("2. Eliminar un cliente según dni");
            System.out.println("3. Buscar un cliente por dni");
            System.out.println("4. Añadir una factura");
            System.out.println("5. Conocer el total de las facturas");
            System.out.println("0. Salir");
            System.out.print("Ingrese su elección: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la Opción 1");
                    clienteImplementa.mostrar();
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2");
                    System.out.print("DNI que deseas eliminar: ");
                    int eliminaDni = scanner.nextInt();
                    clienteImplementa.eliminar(eliminaDni);
                    break;
                case 3:
                    System.out.println("Has seleccionado la Opción 3");
                    System.out.print("Ingresa el DNI: ");
                    int buscaDni = scanner.nextInt();
                    clienteImplementa.buscar(buscaDni);
                    break;
                case 4:
                    System.out.println("Has seleccionado la Opción 4");
                    Factura factura = new Factura(1,new Cliente(235,"Jose","Pepe"),items,1000);
                    if (!clienteImplementa.buscar(factura.getCliente().getDni()).toString().equals(factura.getCliente().toString())){
                        System.out.println("Cliente no encontrado, se agregó a los clientes");
                        clienteImplementa.guardar(factura.getCliente());
                    } else {
                        facturaImplementa.guardar(factura);
                    }
                    break;
                case 5:
                    System.out.println("Has seleccionado la Opción 5");
                    Factura factura2 = new Factura(2,new Cliente(235,"Jose","Pepe"),items,1000);
                    facturaImplementa.guardar(factura2);
                    facturaImplementa.getTotal();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);  // Sale del programa
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}