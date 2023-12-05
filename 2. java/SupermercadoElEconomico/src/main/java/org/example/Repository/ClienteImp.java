package org.example.Repository;

import org.example.Modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente>{

    List<Cliente> listClientes = new ArrayList<>();

    @Override
    public void save(Cliente obj) {
        listClientes.add(obj);
    }

    @Override
    public void mostrarPantalla() {
        listClientes.stream().map(cliente -> {
            return "Cliente " + cliente.getNombre() + cliente.toString();
        }).forEach(System.out::println);
    }

    @Override
    public void buscar(String dni) {
        Optional<Cliente> clienteEnocntrado =  listClientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst();
        clienteEnocntrado.ifPresentOrElse(System.out::println, () -> System.out.println("No se encontro al cliente"));
    }

    @Override
    public void eliminar(String dni) {
        listClientes = listClientes.stream().filter(cliente -> !cliente.getDni().equals(dni)).toList();
    }

    @Override
    public List<Cliente> traerTodos() {
        return listClientes;
    }
}
