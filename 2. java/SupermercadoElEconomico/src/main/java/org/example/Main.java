package org.example;

import org.example.modelo.Cliente;
import org.example.modelo.Producto;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Crear 3 clientes y guardarlos en una collection.
        Cliente cliente1 = new Cliente("Juan", "Perez", "12345678");
        Cliente cliente2 = new Cliente("Maria", "Gomez", "87654321");
        Cliente cliente3 = new Cliente("Pedro", "Gonzalez", "45678912");
        List<Cliente> clientes = new LinkedList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        //Recorrer lista de clientes e imprimirlos
        clientes.forEach(System.out::println);

        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        System.out.println();
        System.out.println("Eliminando cliente 1...");
        clientes.remove(cliente1);
        clientes.forEach(System.out::println);

        // Solicitar por teclado un número de DNI para buscar al cliente
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el número de DNI a buscar:");
        String dniBuscado = scanner.nextLine();

        // Buscar al cliente por DNI
        Optional<Cliente> clienteBuscado = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniBuscado))
                .findFirst();

        // Mostrar resultados
        clienteBuscado.ifPresentOrElse(
                cliente -> {
                    System.out.println("\nCliente encontrado:");
                    System.out.println(cliente);
                },
                () -> System.out.println("\nCliente no encontrado. ¡Ups!")
        );

        scanner.close();

    }
}