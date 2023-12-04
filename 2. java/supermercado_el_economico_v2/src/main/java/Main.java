import model.Cliente;
import repository.ClienteCRUD;
import repository.FacturaCRUD;
import repository.ItemCRUD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteCRUD clienteCRUD = new ClienteCRUD();
        FacturaCRUD facturaCRUD = new FacturaCRUD();
        ItemCRUD itemCRUD = new ItemCRUD();

        clienteCRUD.create(new Cliente(1, "Juan", "Perez"));
        clienteCRUD.create(new Cliente(2, "Maria", "Gomez"));
        clienteCRUD.create(new Cliente(3, "Carlos", "Gutierrez"));
        clienteCRUD.create(new Cliente(4, "Ana", "Sanchez"));
        clienteCRUD.create(new Cliente(5, "Pedro", "Rodriguez"));

        System.out.println("Clientes:");
        clienteCRUD.readAll().forEach(c -> System.out.println("- " + c));

        System.out.println();
        System.out.println("Cliente con DNI 2:");
        System.out.println(clienteCRUD.read(2));

        System.out.println();
        System.out.println("Actualizando cliente con DNI 2:");
        clienteCRUD.update(2, new Cliente(2, "Maria", "Lopez"));
        System.out.println(clienteCRUD.read(2));

        System.out.println();
        System.out.println("Eliminando cliente con DNI 2:");
        clienteCRUD.delete(2);
        System.out.println("Clientes:");
        clienteCRUD.readAll().forEach(c -> System.out.println("- " + c));

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente o 0 para salir: ");
        int dni = scanner.nextInt();

        while (dni != 0) {
            Cliente cliente = clienteCRUD.read(dni);

            if (cliente != null) {
                System.out.println("Cliente encontrado: " + cliente);
            } else {
                System.out.println("Cliente no encontrado");
            }

            System.out.println();
            System.out.println("Ingrese el DNI del cliente o 0 para salir: ");
            dni = scanner.nextInt();
        }
    }
}
