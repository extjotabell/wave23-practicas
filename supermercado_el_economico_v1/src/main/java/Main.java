import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Crear clientes
        Cliente cliente1 = new Cliente("1", "Juan", "Perez");
        Cliente cliente2 = new Cliente("2", "Maria", "Gomez");
        Cliente cliente3 = new Cliente("3", "Pedro", "Gonzalez");

        System.out.println("Lista de clientes:");
        Cliente.getClientes().forEach(System.out::println);
        System.out.println();

        System.out.println("Eliminar cliente con DNI 3:");
        Cliente.eliminar("3");

        System.out.println("Lista de clientes:");
        Cliente.getClientes().forEach(System.out::println);
        System.out.println();

        // Solicitar DNI de un cliente por teclado y buscarlo en la lista
        System.out.print("Ingrese DNI de un cliente o 0 para salir: ");
        String dni = entrada.nextLine();

        while (!dni.equals("0")) {
            String finalDni = dni;

            Cliente cliente = Cliente.buscar(dni);

            if (cliente != null) System.out.println("Cliente encontrado: " + cliente);
            else System.out.println("Cliente no encontrado");

            System.out.println();
            System.out.print("Ingrese DNI de un cliente o 0 para salir: ");
            dni = entrada.nextLine();
        }
    }
}
