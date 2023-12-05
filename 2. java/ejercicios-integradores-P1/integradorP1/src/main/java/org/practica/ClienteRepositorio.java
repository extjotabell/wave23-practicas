package org.practica;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {
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

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removeCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public boolean tieneCliente(Cliente cliente){
        return clientes.contains(cliente);
    }

}
