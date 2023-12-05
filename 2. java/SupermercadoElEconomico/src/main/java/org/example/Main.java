package org.example;

import org.example.Modelo.Cliente;
import org.example.Modelo.Factura;
import org.example.Modelo.Item;
import org.example.Repository.ClienteImp;
import org.example.Repository.FacturaImp;
import org.example.Repository.ItemImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ClienteImp clienteImp = new ClienteImp();

        Cliente cliente1 = new Cliente("123456","Samuel","Urrea");
        Cliente cliente2 = new Cliente("52740897", "Erika", "Fonseca");
        Cliente cliente3 = new Cliente("102678345", "Jhon", "Garcia");

        clienteImp.save(cliente1);
        clienteImp.save(cliente2);
        clienteImp.save(cliente3);

        clienteImp.mostrarPantalla();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente a buscar: ");
        String dniBuscar = teclado.nextLine();
        clienteImp.buscar(dniBuscar);

        System.out.println("Digite el cliente que desea eliminar: ");
        String dniEliminar = teclado.nextLine();
        clienteImp.eliminar(dniEliminar);

        System.out.println("Clientes eliminando el cliente anterior:");
        System.out.println();
        clienteImp.mostrarPantalla();

        //Items
        ItemImp itemImp = new ItemImp();

        Item item1 = new Item("1", "Shampoo", 2, 5000);
        Item item2 = new Item("2", "Desodorante", 3, 2500);

        itemImp.save(item1);
        itemImp.save(item2);

        //Facturacion

        Factura factura = new Factura("1L", cliente1, itemImp.traerTodos(), itemImp.totalCompra());
        FacturaImp facturaImp = new FacturaImp();

        List<Cliente> clienteExistente = clienteImp.traerTodos();

        for (Cliente cliente: clienteExistente) {
            if(cliente.getDni().equals("123456")){
                facturaImp.save(factura);
            } else {
                System.out.println("No se encontró el cliente");
            }
        }



    }
}