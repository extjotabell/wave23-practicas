package org.example.repository;

import org.example.entities.Cliente;

import java.util.ArrayList;

public class ImplementacionCliente implements IGestionable <Cliente> {
    ArrayList<Cliente> clientes = new ArrayList<>();

    @Override
    public String guardar(Cliente cliente) {
        if (cliente != null && !clientes.contains(cliente)) {
            clientes.add(cliente);
            return "Cliente agregado con éxito " + cliente;
        }

        return "No se pudo agregar el cliente";
    }

    @Override
    public ArrayList<Cliente> buscar(Cliente objeto) {
        return null;
    }

    @Override
    public int cantidadRegistros() {
        return 0;
    }
}
