package bootcamp;

/*
De cada cliente se registran: dni, nombre y apellido.
Por otro lado, las facturas que se generan cuando un cliente hace una compra contienen a un cliente, una lista de ítems y el total de la compra.
De cada item o producto se guarda el código, nombre, cantidad comprada y costo unitario.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>(List.of(
                new Cliente("1","Nicolás", "Diaz"),
                new Cliente("2", "Silvia", "Rodriguez"),
                new Cliente("3", "Víctor","Medina")
        ));

        Cliente.imprimirDatosClientes(clientes);

        clientes.remove(1);

        System.out.println();

        Cliente.imprimirDatosClientes(clientes);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el dni del cliente a buscar a buscar: ");
        String dni = teclado.nextLine();
        Cliente.buscarClientePorDNI(clientes, dni);


    }
}