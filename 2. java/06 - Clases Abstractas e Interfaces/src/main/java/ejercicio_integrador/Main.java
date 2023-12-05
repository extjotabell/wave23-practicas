package ejercicio_integrador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado("El Económico");
        //Crear 3 clientes y guardarlos en una collection.
        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(new Cliente("Ailen", "Vilches", "38855748"));
        clienteList.add(new Cliente("Paula", "Vilches", "21924803"));
        clienteList.add(new Cliente("Nahuel", "Vilches", "42155747"));

        //Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        supermercado.mostrarClientes();

        //Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un DNI a buscar:");
        String dni = scanner.nextLine();
        while(dni.isEmpty()){
            System.out.println("No puede estar vacío");
            System.out.println("Ingrese un DNI correcto");
            dni = scanner.nextLine();
        }
        System.out.println("\n" + supermercado.buscarClienteByDni(dni));
        scanner.close();
        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        supermercado.eliminarCliente(clienteList.get(0));
        System.out.println();
        supermercado.mostrarClientes();

        //Crear una nueva factura.
        //Crar Items
        Cliente clienteFactura = clienteList.get(0);
        List<Item> productos = new ArrayList<>(Arrays.asList(
                new Item(1,"Leche", 2, 500.00),
                new Item(1,"Pan", 1, 700.00),
                new Item(1,"Galletitas", 3, 220.50),
                new Item(1,"Shampoo", 1, 745.30)));

        System.out.println(supermercado.generarFactura(clienteFactura,productos));


    }

}
