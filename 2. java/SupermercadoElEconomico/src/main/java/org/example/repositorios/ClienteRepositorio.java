package org.example.repositorios;

import org.example.modelo.CRUD;
import org.example.modelo.Cliente;

import java.util.List;

public class ClienteRepositorio extends CRUD<Cliente> {


    public ClienteRepositorio(List<Cliente> clientes) {
        super(clientes);
    }

    public Cliente consultarPorId(String id) {
        return consultar().stream().filter(cliente -> cliente.getDni().equals(id)).findFirst().orElse(null);
    }

}
