package org.example.CRUD;

import org.example.entities.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteCRUD implements CRUD<Cliente> {

    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Método para dar de alta un cliente
     * @param cliente
     * @return Sí no existe, lo crea y retorna el cliente. Sí no, retorna null.
     */
    @Override
    public Cliente create(Cliente cliente) {
        System.out.println("\nCreando cliente: " + cliente);

        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            System.out.println("Cliente agregado correctamente");
            return cliente;
        } else {
            System.out.println("El cliente ya se encuentra registrado");
            return null;
        }
    }

    /**
     * Método para eliminar a un cliente
     * @param cliente
     */
    @Override
    public void delete(Cliente cliente) {
        System.out.println("\nEliminando cliente DNI: " + cliente.getDni());
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            System.out.println("Cliente eliminado correctamente");
        } else {
            System.out.println("El cliente no se encuentra registrado");
        }
    }

    /**
     * Método para buscar un cliente por su dni
     * @param dni
     * @return Sí existe, retorna el cliente. Sí no, retorna null.
     */
    @Override
    public Cliente read(Long dni) {
        Optional<Cliente> cliente = clientes.stream()
                .filter(clienteRegistrado -> dni.equals(clienteRegistrado.getDni()))
                .findFirst();

        if (cliente.isEmpty()) {
            System.out.println("No se encontró un cliente con los datos ingresados");
            return null;
        }

        System.out.println("\nEl cliente solicitado es:");
        System.out.println(cliente.get());
        return cliente.get();
    }

    /**
     * Método para devolver todos los clientes almacenados
     */
    @Override
    public List<Cliente> findAll() {
        return clientes;
    }

    /**
     * Método para validar la existencia de un cliente. Sí el cliente no existe, lo crea.
     * @param cliente
     */
    public void validarCliente(Cliente cliente) {
        System.out.println("\nValidando cliente: " + cliente);
        Cliente clienteRegistrado = this.read(cliente.getDni());

        if (clienteRegistrado == null) {
            this.create(cliente);
        }
        System.out.println("Cliente correctamente validado");
    }
}
