package org.test;

import org.bootcamp.Cliente;
import org.bootcamp.Factura;
import org.bootcamp.Item;
import org.repository.ClienteImp;
import org.repository.FacturaImp;
import org.repository.ItemImp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        //Implementaciones
        ClienteImp clienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();
        ItemImp itemImp = new ItemImp();

        Cliente lucas = new Cliente(23857839L, "Lucas", "Salerno");
        Cliente martin = new Cliente(32758923L, "Martin", "Perez");
        Cliente maria = new Cliente(28431972L, "Maria", "Fernandez");

        // Grabado de clientes
        clienteImp.save(lucas);
        clienteImp.save(martin);
        clienteImp.save(maria);

        // Impresion de lista
        System.out.println("Lista Original");
        clienteImp.mostrarPantalla();

        System.out.println();

        /*
        // Busqueda de cliente por DNI
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI a buscar: ");
        Long dniBuscar = scanner.nextLong();
        clienteImp.buscar(dniBuscar);

        System.out.println();

        // Borrado de cliente por DNI
        System.out.print("Ingrese el dni a eliminar: ");
        Long dniEliminar = scanner.nextLong();
        clienteImp.eliminar(dniEliminar);
        */

        //Factura
        Item fruta = new Item(1L, 4, "Manzana", 2.5);
        Item pan = new Item (2L, 2, "Pan", 5);
        Item arroz = new Item(3L, 1, "Arroz", 10);

        itemImp.save(fruta);
        itemImp.save(pan);
        itemImp.save(arroz);

        Factura factura = new Factura(1l, clienteImp.buscar(23857839L).get(), itemImp.traerTodos(), itemImp.calcularTotal());

        facturaImp.save(factura);

        facturaImp.mostrarPantalla();
    }

}
