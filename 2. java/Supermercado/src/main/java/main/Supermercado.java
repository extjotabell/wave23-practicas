package main;

import java.util.*;

public class Supermercado {
    private List<Cliente> clientes;

    public Supermercado() {
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void mostrarClientes() {
        for (Cliente c : this.clientes) {
            System.out.println(c + "\n");
        }
    }

    public void agregarCliente(Cliente c) {
        this.clientes.add(c);
    }

    public void borrarCliente(Cliente c) {
        this.clientes.remove(c);
    }

    public Cliente buscarCliente(String DNIBuscado) {
        Cliente clienteBuscado = null;

        for (Cliente c : this.clientes) {
            if (Objects.equals(c.getDni(), DNIBuscado)) {
                clienteBuscado = c;
            }
        }

        return clienteBuscado;
    }

    public boolean esCliente(Cliente c) {
        return this.clientes.contains(c);
    }
}
