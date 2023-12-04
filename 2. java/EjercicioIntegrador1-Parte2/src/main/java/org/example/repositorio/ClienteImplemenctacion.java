package org.example.repositorio;

import org.example.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImplemenctacion implements CRUDRepositorio<Cliente>{

    List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void save(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Cliente c : listaClientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
            System.out.println("------------------------------");
        }
    }

    @Override
    public Optional<Cliente> buscar(int dni) {
        boolean encontrado = false;

        for (Cliente c : listaClientes) {
            if (c.getDni() == dni) {
                listaClientes.remove(c);
                return Optional.of(c);
            }
        }

        if (encontrado == false) {
            System.out.println("Cliente no encontrado");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(int dniBorrado) {
       Optional<Cliente> c = this.buscar(dniBorrado);

        if (c.isEmpty()) {
            System.out.println("No se encontró el cliente a borrar");
        }
        else {
            System.out.println("Cliente borrado correctamente");
            listaClientes.remove(c.get());
        }

    }

    @Override
    public List<Cliente> traerTodos() {
        return listaClientes;
    }
}
