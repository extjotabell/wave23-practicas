import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>(
            List.of(
                new Cliente("1", "Juan", "Perez"),
                new Cliente("2", "Maria", "Gomez"),
                new Cliente("3", "Jose", "Garcia")
            )
        );

        System.out.println("Lista de clientes:");
        clientes.forEach(System.out::println);
        System.out.println();

        System.out.println("Eliminar cliente con DNI 87654321:");
        clientes.remove(2);

        System.out.println("Lista de clientes:");
        clientes.forEach(System.out::println);
        System.out.println();

        // Solicitar DNI de un cliente por teclado y buscarlo en la lista
        System.out.print("Ingrese DNI de un cliente o 0 para salir: ");
        String dni = entrada.nextLine();

        while (!dni.equals("0")) {
            String finalDni = dni;

            Cliente cliente = clientes.stream()
                    .filter(c -> c.getDni().equals(finalDni))
                    .findFirst()
                    .orElse(null);

            if (cliente != null) System.out.println("Cliente encontrado: " + cliente);
            else System.out.println("Cliente no encontrado");

            System.out.println();
            System.out.print("Ingrese DNI de un cliente o 0 para salir: ");
            dni = entrada.nextLine();
        }
    }
}
