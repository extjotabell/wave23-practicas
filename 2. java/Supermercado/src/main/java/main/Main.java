package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Supermercado sm = new Supermercado();

        Cliente c1 = new Cliente("40955907", "Marcos", "Costanzo");
        Cliente c2 = new Cliente("22453321", "Pepe", "Gonzalez");
        Cliente c3 = new Cliente("9213422", "Martin", "Chavez");
        sm.agregarCliente(c1);
        sm.agregarCliente(c2);
        sm.agregarCliente(c3);

        System.out.println("CLIENTES ACTUALES\n");
        sm.mostrarClientes();
        System.out.println("--------------------------------");

        sm.borrarCliente(c1);

        System.out.println("CLIENTES POST BORRADO\n");
        sm.mostrarClientes();
        System.out.println("--------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.printf("Ingrese el número de DNI del cliente buscado: ");
        String DNIBuscado = sc.nextLine();

        Cliente clienteBuscado = sm.buscarCliente(DNIBuscado);
        if (clienteBuscado != null) {
            System.out.println("El cliente buscado posee los siguientes datos:");
            System.out.println(clienteBuscado);
        }
        else {
            System.out.println("El cliente con DNI " + DNIBuscado + " no existe");
        }
    }
}
