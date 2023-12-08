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

        ClienteImp clienteRepository = new ClienteImp();

        clienteRepository.save(new Cliente(1L,"Nicolás", "Diaz"));
        clienteRepository.save(new Cliente(2L,"Silvia", "Rodriguez"));
        clienteRepository.save(new Cliente(3L,"Victor", "Medina"));

        clienteRepository.printElements();

        clienteRepository.delete(1L);

        System.out.println();

        clienteRepository.printElements();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el dni del cliente a buscar: ");
        Long dni = teclado.nextLong();
        clienteRepository.buscarClientePorDNI(dni);

        ItemImp itemRepository = new ItemImp();

        itemRepository.save(new Item(2L, "Pan",4, 5));
        itemRepository.save(new Item(3L, "carne", 1.5, 70));

        Factura factura = new Factura(clienteRepository.search(2L).get(),itemRepository);
        Factura.agregarFactura(factura, clienteRepository);

        System.out.println(factura);

    }
}