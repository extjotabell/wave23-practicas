package org.example.entities;

import java.util.*;

public class Supermercado {

    private static List<Cliente> clientes = new ArrayList<>();

    public static Cliente crearCliente(Cliente cliente) {
        System.out.println("\nCreando cliente: " + cliente);

        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            System.out.println("Cliente agregado correctamente");
        } else {
            System.out.println("El cliente ya se encuentra registrado");
        }
        return cliente;
    }

    public static void listarClientes() {
        System.out.println("\nListando clientes:");
        clientes.forEach(System.out::println);
    }

    public static void eliminarCliente(Cliente cliente) {
        System.out.println("\nEliminando cliente: " + cliente);
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            System.out.println("Cliente eliminado correctamente");
        } else {
            System.out.println("El cliente no se encuentra registrado");
        }
    }

    public static void buscarCliente() {
        System.out.println("\nIngrese el dni del cliente que desea buscar");

        try {
            Scanner sc = new Scanner(System.in);
            Integer dni = sc.nextInt();
            Optional<Cliente> cliente = clientes.stream()
                    .filter(clienteRegistrado -> dni.equals(clienteRegistrado.getDni()))
                    .findFirst();

            if (cliente.isEmpty()) {
                System.out.println("No se encontró un cliente con los datos ingresados");
                throw new IllegalArgumentException();
            }
            System.out.println("El cliente solicitado es:");
            System.out.println(cliente.get());
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese únicamente números");
            buscarCliente();
        }
    }
}
