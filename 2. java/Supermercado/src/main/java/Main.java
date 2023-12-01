import models.Cliente;
import models.Supermercado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Supermercado singleton = Supermercado.getInstance();
        singleton.addCliente(new Cliente("44967716", "Felipe","Costa"));
        singleton.addCliente(new Cliente("32133426", "Jorge","Perez"));
        singleton.addCliente(new Cliente("24742497", "Pepe","Gutierrez"));

        singleton.mostrarClientes();

        System.out.println("Eliminando a Pepe por su DNI");
        System.out.println(singleton.eliminarCliente("24742497")?"Se elimino correctamente":"Ocurrio un error");

        singleton.mostrarClientes();

        System.out.print("Ingrese el DNI del usuario a mostrar:");
        singleton.mostrarCliente(scanner.next());
    }
}
