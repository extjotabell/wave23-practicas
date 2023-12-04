package org.example;

import org.example.modelo.CRUD;
import org.example.modelo.Cliente;
import org.example.modelo.Producto;
import org.example.repositorios.ClienteRepositorio;
import org.example.repositorios.ProductoRepositorio;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final ClienteRepositorio clienteRepositorio = new ClienteRepositorio(new LinkedList<>());
    private static final ProductoRepositorio productoRepositorio = new ProductoRepositorio(new LinkedList<>());
    public static void main(String[] args) {

        // Crear 3 clientes y guardarlos en una colección.
        Cliente cliente1 = new Cliente("Juan", "Perez", "12345678");
        Cliente cliente2 = new Cliente("Maria", "Gomez", "87654321");
        Cliente cliente3 = new Cliente("Pedro", "Gonzalez", "45678912");

        clienteRepositorio.agregar(cliente1);
        clienteRepositorio.agregar(cliente2);
        clienteRepositorio.agregar(cliente3);

        // Recorrer lista de clientes e imprimirlos
        clienteRepositorio.consultar().forEach(System.out::println);

        // Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        System.out.println("\nEliminando cliente 1...");
        clienteRepositorio.eliminar(cliente1);
        clienteRepositorio.consultar().forEach(System.out::println);

        // Solicitar por teclado un número de DNI para buscar al cliente
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nIngrese el número de DNI a buscar:");
            String dniBuscado = scanner.nextLine();

            // Buscar al cliente por DNI
            Optional<Cliente> clienteBuscado = Optional.ofNullable(clienteRepositorio.consultarPorId(dniBuscado));

            // Mostrar resultados
            clienteBuscado.ifPresentOrElse(
                    cliente -> {
                        System.out.println("\nCliente encontrado:");
                        System.out.println(cliente);
                    },
                    () -> System.out.println("\nCliente no encontrado. ¡Ups!")
            );
        }



    }
}
