import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean encontrarCliente(List<Cliente> listaCliente, int dniCliente) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getDni() == dniCliente) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente1 = new Cliente("Andres", "Limpio", 1234);
        Cliente cliente2 = new Cliente("Andrea", "Limpio", 5678);
        Cliente cliente3 = new Cliente("Alejandro", "Diaz", 7890);

        List<Cliente> listaCliente = new ArrayList<>();
        listaCliente.add(cliente1);
        listaCliente.add(cliente2);
        listaCliente.add(cliente3);

        System.out.println("------Lista Clientes------");
        listaCliente.forEach(System.out::println);

        int posicionEliminada = 2;

        System.out.println("\n-----Lista Clientes, eliminando al #" + posicionEliminada + "-----\n");
        listaCliente.remove(posicionEliminada);
        listaCliente.forEach(System.out::println);

        System.out.print("\nInserta el dni de un número de cliente, para buscarlo: ");
        int dniCliente = sc.nextInt();

        if (encontrarCliente(listaCliente, dniCliente)) {
            System.out.println("\nSe encuentra el DNI del cliente");
        } else {
            System.out.println("\nDNI no encontrado");
        }
    }
}
