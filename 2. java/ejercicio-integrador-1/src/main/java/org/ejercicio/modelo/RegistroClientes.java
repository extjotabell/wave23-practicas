package org.ejercicio.modelo;

import org.ejercicio.modelo.interfaces.IOPeraciones;

import java.util.List;

public class RegistroClientes implements IOPeraciones<Cliente,String> {
    private List<Cliente> clientes;

    public RegistroClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public boolean guardar(Cliente nuevoCliente) {
        return getClientes().add(nuevoCliente);
    }

    @Override
    public void mostrar() {
        System.out.println(this.toString());
    }

    @Override
    public boolean eliminar(Cliente clienteAEliminar) {
        return getClientes().remove(clienteAEliminar);
    }

    @Override
    public void actualizar(Cliente clienteAActualizar) {
        getClientes().set(getClientes().indexOf(encontrarPorId(clienteAActualizar.getDni())), clienteAActualizar);
    }

    @Override
    public Cliente encontrarPorId(String dni) {
        return clientes.stream().filter(c -> c.getDni() == dni).findFirst().get();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "RegistroClientes{" +
                "clientes=" + clientes +
                '}';
    }

}
