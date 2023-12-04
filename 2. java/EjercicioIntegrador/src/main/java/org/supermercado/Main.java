package org.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Cliente> clientes  = new ArrayList<>();
        List<Factura> facturas = new ArrayList<>();

        SuperMercado superMercado = new SuperMercado(clientes, facturas);
        superMercado.agregarCliente(new Cliente(1, "Diana", "Ramírez"));
        superMercado.agregarCliente(new Cliente(2, "Manuel", "Barajas"));
        superMercado.agregarCliente(new Cliente(3, "Lisandro", "Monreal"));
        Cliente cliente1 = new Cliente(4, "José", "Gamboa");
        superMercado.agregarCliente(cliente1);


        System.out.println("Imprimiendo clientes");
        superMercado.imprimirClientes();
        System.out.println();
        System.out.println("Eliminando cliente");
        superMercado.eliminarCliente(cliente1);
        System.out.println();
        System.out.println("Imprimiendo clientes");
        superMercado.imprimirClientes();
        System.out.println();
        System.out.println("Buscando cliente");
        superMercado.buscarCliente(4);

        Item item1 = new Item("123","jabón roma", 2,60);
        Item item2 = new Item("1234", "shampoo sedal", 1, 50);
        Item item3 = new Item("12345","pasta de dientes colgate", 3,25.5);


        List<Item> listaItem = new ArrayList<>();
        Factura factura1 = new  Factura(cliente1,listaItem);

        factura1.agregarItem(item1);
        factura1.agregarItem(item2);
        factura1.agregarItem(item3);
        Factura factura2 = new Factura(new Cliente(3, "Lisandro", "Monreal"),listaItem);

        factura2.agregarItem(item1);
        factura2.agregarItem(item2);
        factura2.agregarItem(item3);

        superMercado.agregarFactura(factura1);
        System.out.println(factura1);
        System.out.println();

        superMercado.agregarFactura(factura2);
        System.out.println(factura2);
        System.out.println();

        System.out.println("Imprimiendo clientes");
        superMercado.imprimirClientes();
        System.out.println();

    }
}
