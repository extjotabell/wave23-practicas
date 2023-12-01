package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>(Arrays.asList(
                new Cliente("Miguel", "Ochoa", "10"),
                new Cliente("Sara", "Alvarez", "12"),
                new Cliente("Julian", "Perez", "14")
        ));

        clientes.forEach(System.out::println);

        clientes.removeIf(cliente -> cliente.getNombre().equalsIgnoreCase("miguel"));

        System.out.println("Se elimino un cliente");

        clientes.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI de un cliente para consultar su informacion: ");

        String dni = scanner.nextLine();

        Optional<Cliente> clienteFiltrado = clientes.stream().
                filter(cliente -> cliente.getDni().equals(dni)).findFirst();

        if (clienteFiltrado.isPresent()) System.out.println(clienteFiltrado.get());
        else System.out.println("No se encontro un cliente con el DNI especificado");
    }
}