package models;

import Exceptions.ClientNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private static Supermercado instance;
    private List<Cliente> clientes;
    private List<Factura> facturas;

    public static Supermercado getInstance(){
        if(instance==null){
            instance=new Supermercado();
        }
        return instance;
    }
    private Supermercado(){
        clientes= new ArrayList<>();
        facturas=new ArrayList<>();
    }

    public void addCliente(Cliente cliente){
        if(clientes.contains(cliente)){
            System.out.println("El cliente ya se encuentra registrado");
        }else{
            clientes.add(cliente);
            System.out.println("Se ha registrado al cliente correctamente");
        }
    }

    public Cliente buscarCliente(String dni) throws ClientNotFoundException {
        return clientes.stream().filter(client->client.getDni().equalsIgnoreCase(dni)).findFirst().orElseThrow(()->new ClientNotFoundException(dni));
    }

    public void mostrarClientes(){
        System.out.println("\nMostrando clientes:");
        clientes.forEach(System.out::println);
        System.out.println();
    }

    public void mostrarCliente(String dni){
        try {
            Cliente cliente = buscarCliente(dni);
            System.out.println(cliente);
        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean eliminarCliente(String dni){
        try {
            Cliente cliente = buscarCliente(dni);
            return clientes.remove(cliente);
        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
