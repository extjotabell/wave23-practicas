package bootcamp;

/*
De cada cliente se registran: dni, nombre y apellido.
Por otro lado, las facturas que se generan cuando un cliente hace una compra contienen a un cliente, una lista de ítems y el total de la compra.
De cada item o producto se guarda el código, nombre, cantidad comprada y costo unitario.
 */

import java.util.ArrayList;
import java.util.List;

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

        System.out.println();
        Cliente.buscarClientePorDNI(clientes, "1");
        System.out.println();
        Cliente.buscarClientePorDNI(clientes, "2");


    }
}