package org.example.repositorio;

import org.example.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private List<Cliente> clientes;

    public Repositorio() {
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
}
