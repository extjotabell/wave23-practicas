package org.example.repos;

import org.example.Cliente;
import org.example.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImplementacionItem implements IConsultable<Item> {
    ArrayList<Item> items = new ArrayList<>();

    @Override
    public void guardar(Item objeto) {
        items.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Item i : items) {
            System.out.println("Nombre: " + i.getNombre());
            System.out.println("Costo unitario: " + i.getCostoUnitario());
            System.out.println("Cantidad comprada: " + i.getCantidadComprada());
        }
    }

    @Override
    public Optional<Item> buscar(Long id) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public void buscarEliminarPorNombre(String nombre) {
    }

    @Override
    public List<Item> traerTodos() {
        return items;
    }
}
