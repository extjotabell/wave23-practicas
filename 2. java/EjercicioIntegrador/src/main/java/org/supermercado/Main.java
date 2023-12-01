package org.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void eliminarCliente(List<Cliente> clientes, Cliente cliente){
        clientes.remove(cliente);
    }

    public static  void imprimirClientes(List<Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static  void buscarCliente(List<Cliente> clientes, int dni){
        Optional<Cliente> buscado = clientes.stream()
                .filter(cliente -> cliente.getDni() == dni).findFirst();

        buscado.ifPresentOrElse(
                (cliente)
                        -> {
                    System.out.println("Cliente encontrado: ");
                    System.out.println(cliente);
                },
                ()
                        ->{
                    System.out.println("Cliente no encontrado");
                });

    }

    public static void main(String[] args) {
        List<Cliente> clientes  = new ArrayList<>();
        Cliente cliente1 = new Cliente(4, "José", "Gamboa");
        clientes.add(new Cliente(1, "Diana", "Ramírez"));
        clientes.add(new Cliente(2, "Manuel", "Barajas"));
        clientes.add(new Cliente(3, "Lisandro", "Monreal"));
        clientes.add(cliente1);
        System.out.println("Imprimiendo clientes");
        imprimirClientes(clientes);
        System.out.println();
        System.out.println("Eliminando cliente");
        eliminarCliente(clientes,cliente1);
        System.out.println();
        System.out.println("Imprimiendo clientes");
        imprimirClientes(clientes);
        System.out.println();
        System.out.println("Buscando cliente");
        buscarCliente(clientes, 4);
    }
}
