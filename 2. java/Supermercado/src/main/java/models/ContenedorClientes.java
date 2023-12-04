package models;

import Exceptions.ClientNotFoundException;
import Exceptions.ElementNotFoundException;
import interfaces.interfaceCRUD;

import java.util.ArrayList;
import java.util.List;

public class ContenedorClientes implements interfaceCRUD<Cliente> {
    private List<Cliente> clientes;

    public ContenedorClientes() {
        clientes = new ArrayList<>();
    }

    @Override
    public Cliente getById(String id) throws ElementNotFoundException {
        return clientes.stream().filter(client -> client.getDni().equalsIgnoreCase(id)).findFirst().orElseThrow(() -> new ClientNotFoundException(id));
    }

    @Override
    public boolean delete(String id) {
        try {
            Cliente cliente = getById(id);
            return clientes.remove(cliente);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void add(Cliente element) {
        if (clientes.contains(element)) {
            System.out.println("El cliente ya se encuentra registrado");
        } else {
            clientes.add(element);
            System.out.println("Se ha registrado al cliente correctamente");
        }
    }

    @Override
    public void showAll() {
        System.out.println("\nMostrando clientes:");
        clientes.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void showById(String id) {
        try {
            Cliente cliente = getById(id);
            System.out.println(cliente);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
