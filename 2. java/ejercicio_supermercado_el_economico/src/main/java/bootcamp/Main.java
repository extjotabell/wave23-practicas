package bootcamp;

/*
De cada cliente se registran: dni, nombre y apellido.
Por otro lado, las facturas que se generan cuando un cliente hace una compra contienen a un cliente, una lista de ítems y el total de la compra.
De cada item o producto se guarda el código, nombre, cantidad comprada y costo unitario.
 */

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static bootcamp.Cliente.clientes;

public class Main {
    public static void main(String[] args) {

        Cliente.imprimirDatosClientes(clientes);

        clientes.remove(1);

        System.out.println();

        Cliente.imprimirDatosClientes(clientes);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el dni del cliente a buscar a buscar: ");
        String dni = teclado.nextLine();
        Cliente.buscarClientePorDNI(clientes, dni);

        Factura factura = new Factura(clientes.get(0),new ArrayList<Item>(List.of(
                new Item("AXOIUE", "Pan", 4,5),
                new Item("AOFMNIUE98", "Carne", 1.5, 70)
                )));
        Factura.agregarFactura(factura);

        System.out.println(factura);

    }
}