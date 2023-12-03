package org.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        Cliente client1 = new Cliente(1234, "Camila", "Mamani");
        Cliente client2 = new Cliente(5678, "Emilia", "Lopez");
        Cliente client3 = new Cliente(1212, "Maria", "Torres");

        clientes.add(client1);
        clientes.add(client2);
        clientes.add(client3);

        clientes.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese dni del cliente a borrar:");
        String dni = scanner.next();
        Optional<Cliente> client = clientes.stream().filter(c-> String.valueOf(c.getDni()).equals(dni)).findFirst();
        if(client.isPresent()){
            clientes.remove(client.get());
            System.out.println("Cliente Borrado correctamente");
        }else{
            System.out.println("No se encontró el cliente con el dni ingresado.");
        }

        clientes.forEach(System.out::println);


        System.out.println("Ingrese dni del cliente a buscar:");
        String dni2 = scanner.next();
        Optional<Cliente> cliente = clientes.stream().filter(c-> String.valueOf(c.getDni()).equals(dni2)).findFirst();
        if(cliente.isPresent()){
            System.out.println("Cliente Encontrado: "+cliente.get());
        }else{
            System.out.println("No se encuentra un cliente con el dni ingresado.");
        }


    }
}