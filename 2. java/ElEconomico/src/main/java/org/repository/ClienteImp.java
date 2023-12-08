package org.repository;

import org.bootcamp.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements ICRUDRepository<Cliente> {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        clientes.forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(Long dni) {
        boolean bandera = false;
        for (Cliente cliente : clientes){
            if (cliente.getDni().equals(dni)){
                System.out.println(cliente.toString());
                return Optional.of(cliente);
            }
        }

        if (bandera == false) {
            System.out.println("Cliente no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long dni) {
        Optional<Cliente> cliente = this.buscar(dni);
        if (cliente.isEmpty()){
            System.out.println("No se encontro el cliente a borrar");
        }
        else{
            System.out.println("Cliente borrado correctamente");
            clientes.remove(cliente.get());
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }

}
