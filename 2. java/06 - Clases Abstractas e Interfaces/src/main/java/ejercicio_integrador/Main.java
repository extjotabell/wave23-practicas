package ejercicio_integrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Crear 3 clientes y guardarlos en una collection.
        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(new Cliente("Ailen", "Vilches", "38855748"));
        clienteList.add(new Cliente("Paula", "Vilches", "21924803"));
        clienteList.add(new Cliente("Nahuel", "Vilches", "42155747"));

        //Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        Supermercado.mostrarClientes(clienteList);

        //Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
        System.out.println("Ingrese un DNI a buscar:");
        String dni = scanner.nextLine();
        while(dni.isEmpty()){
            System.out.println("No puede estar vacío");
            System.out.println("Ingrese un DNI correcto");
            dni = scanner.nextLine();
        }
        System.out.println("\n" + Supermercado.buscarClienteByDni(clienteList, dni));
        scanner.close();
        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        Supermercado.eliminarCliente(clienteList, clienteList.get(0));
        System.out.println();
        Supermercado.mostrarClientes(clienteList);
    }
}
