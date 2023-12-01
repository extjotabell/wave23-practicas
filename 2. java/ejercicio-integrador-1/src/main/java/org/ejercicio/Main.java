package org.ejercicio;

import org.ejercicio.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static List<Cliente> clientes;
    public static void main(String[] args) {

        //1. Clientes iniciales
        cargarClientes();

        //3. Eliminar cliente
        String dniEliminar = "3412007";
        System.out.println("CLIENTES ACTUALES: ");
        mostrarInfoClientes();

        System.out.println("-----Eliminando al cliente con DNI: " + dniEliminar);
        eliminarCliente(dniEliminar);

        System.out.println("CLIENTES ACTUALIZADOS: ");
        mostrarInfoClientes();

        buscarCliente();


    }

    public static void cargarClientes(){
        Cliente clienteUno = new Cliente("3412007", "Daniel", "Jimenez");
        Cliente clienteDos = new Cliente("3423001", "Emilia", "Vargas");
        Cliente clienteTres = new Cliente("3412034", "Paula", "Lopez");

        clientes = new ArrayList<>(List.of(clienteUno, clienteDos, clienteTres));
    }

    public static void mostrarInfoClientes(){
        clientes.forEach(System.out::println);
    }
    public static void eliminarCliente(String dniEliminar) {
        Optional<Cliente> clienteAux = clientes.stream().filter(c -> c.getDni().equals(dniEliminar) ).findFirst();
        if( clienteAux.isPresent()) clientes.remove(clienteAux.get());
        else System.out.println("El cliente con DNI "+ dniEliminar + " no existe.");
    }

    private static void buscarCliente() {
        System.out.println("Ingrese el dni del cliente que desea buscar:");
        Scanner teclado = new Scanner(System.in);
        String dniABuscar = teclado.nextLine();

        System.out.println("Usted ingresó el dni: "+ dniABuscar);
        Optional<Cliente> clienteAux = clientes.stream().filter(c -> c.getDni().equals(dniABuscar) ).findFirst();
        if( clienteAux.isPresent()) System.out.println("CLIENTE ENCONTRADO: "+ clienteAux.get().toString() );
        else System.out.println("El cliente con DNI "+ dniABuscar + " no existe.");

    }

}