package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(12345673, "Nico", "Reinaldo");
        Cliente cliente2 = new Cliente(24344244, "Lolo", "Manss");
        Cliente cliente3 = new Cliente(43097714, "Abril", "Bonna");


        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        for (Cliente c : listaClientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
            System.out.println("------------------------------");
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni del client que quieres borrar");
        String dniBorrado = teclado.next();
        boolean borrado = false;

        for (Cliente c : listaClientes) {
            if (c.getDni() == (Integer.parseInt(dniBorrado))) {
                listaClientes.remove(c);
                borrado = true;
                break;
            }
        }
        if (borrado) {
            System.out.println("Cliente borrado");
            for (Cliente c : listaClientes) {
                System.out.println("Dni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                System.out.println("------------------------------");
            }
        }
        else {
            System.out.println("No se encontró el cliente para borrar");
        }

        System.out.println("Ingrese el dni para buscar al Cliente: ");
        String dniBuscado = teclado.next();

        for (Cliente c : listaClientes) {
            if (c.getDni() == Integer.parseInt(dniBuscado)) {
                System.out.println("Dni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                break;
            }
        }

    }
}