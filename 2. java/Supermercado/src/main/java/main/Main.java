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

        // Cliente nuevo
        Cliente clienteNuevo = new Cliente("1234567", "Sandro", "Perez");

        Item i1 = new Item(1, "Pan Bimbo Artesano", 2, 1500);
        Item i2 = new Item(2, "Arroz Carrefour", 2, 1200);
        Item i3 = new Item(3, "Soda Manaos", 6, 500);
        List<Item> items = new ArrayList<>(Arrays.asList(i1, i2, i3));
        Factura f1 = new Factura(sm, clienteNuevo, items);

        System.out.println("Total compra: " + f1.getTotalCompra());

        /*System.out.println("CLIENTES ACTUALES\n");
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
        }*/


    }
}
