package org.example.repos;

import org.example.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ImplementacionCliente implements IConsultable<Cliente> {

    ArrayList<Cliente> clientes = new ArrayList<>();
    @Override
    public void guardar(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Cliente c : clientes) {
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
            System.out.println("Dni: " + c.getDni());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long id) {
        for (Cliente c : clientes) {
            if (Objects.equals(c.getDni(), id)) {
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        Optional<Cliente> buscado = this.buscar(id);

        if (buscado.isPresent()) {
            clientes.remove(buscado);
        }
    }

    @Override
    public void buscarEliminarPorNombre(String nombre) {
        Cliente buscado = null;
        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre)) {
                buscado = c;
            }
        }

        if (buscado != null) {
            clientes.remove(buscado);
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }
}
