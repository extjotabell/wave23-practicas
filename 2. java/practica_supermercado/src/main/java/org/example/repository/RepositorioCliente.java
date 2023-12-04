package org.example.repository;

import org.example.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioCliente implements CRUDRepository<Cliente> {
    private final List<Cliente> clientes;

    public RepositorioCliente() {
        clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public Cliente create(Cliente entity) {
        clientes.add(entity);
        return entity;
    }

    @Override
    public Optional<Cliente> read(int id) {
        return clientes.stream().filter(cliente -> cliente.getId() == id).findFirst();
    }

    @Override
    public Cliente update(int id, Cliente entity) {
        Optional<Cliente> cliente = read(id);

        cliente.ifPresent(value -> {
            value.setNombre(entity.getNombre());
            value.setApellido(entity.getApellido());
            value.setDni(entity.getDni());
        });

        return cliente.orElse(null);
    }

    @Override
    public void delete(int id) {
        Optional<Cliente> cliente = read(id);
        cliente.ifPresent(clientes::remove);
    }

    @Override
    public void listAll() {
        clientes.forEach(System.out::println);
    }
}
