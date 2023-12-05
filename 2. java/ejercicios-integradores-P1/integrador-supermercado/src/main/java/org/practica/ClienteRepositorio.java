package org.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositorio implements Repositorio<Cliente>{
    private static ClienteRepositorio instancia;
    private List<Cliente> clientes;

    private ClienteRepositorio(){
        clientes = new ArrayList<>();
    }
    public static ClienteRepositorio getInstancia() {
        if (instancia == null) {
            instancia = new ClienteRepositorio();
        }
        return instancia;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public boolean tieneCliente(Cliente cliente){
        return clientes.contains(cliente);
    }

    @Override
    public void create(Cliente client) {
        clientes.add(client);
    }

    @Override
    public void remove(Cliente client) {
        Optional<Cliente> cliente = clientes.stream().filter(c -> c.getDni() == client.getDni()).findFirst();
        cliente.ifPresent(value -> clientes.remove(value));
        if(cliente.isEmpty())
            System.out.println("No se encontró el Cliente.");
    }

    @Override
    public void update(Cliente client) {
        Optional<Cliente> cliente = clientes.stream().filter(c -> c.getDni() == client.getDni()).findFirst();
        cliente.ifPresent(value -> value = client);
        if(cliente.isEmpty())
            System.out.println("No se encontró el Cliente.");
    }

    @Override
    public Cliente getById(int dni) {
        Optional<Cliente> cliente = clientes.stream().filter(c -> c.getDni() == dni).findFirst();
        return cliente.orElse(null);
    }
}
