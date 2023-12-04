package org.example.clientes;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {
    private final Map<String, Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }

    public Cliente buscarCliente(String dni) {
        return clientes.get(dni);
    }
}
