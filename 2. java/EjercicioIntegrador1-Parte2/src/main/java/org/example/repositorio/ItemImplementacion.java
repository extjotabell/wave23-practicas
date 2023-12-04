package org.example.repositorio;

import org.example.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImplementacion implements CRUDRepositorio<Item> {

    List <Item> listaItems = new ArrayList<>();

    @Override
    public void save(Item objeto) {
        listaItems.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Item it : listaItems) {
            System.out.println(it.toString());
        }
    }

    @Override
    public Optional<Item> buscar(int codigoBuscado) {
        boolean encontrado = false;
        for (Item i : listaItems) {
            if (i.getCodigo() == codigoBuscado) {
                System.out.println("Item: ");
                System.out.println(i);
                return Optional.of(i);
            }
        }

        if (!encontrado) {
            System.out.println("Item no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(int codigoBorrado) {
        Optional<Item> it = this.buscar(codigoBorrado);

        if (it.isEmpty()) {
            System.out.println("No se encontró el item ");
        }
        else {
            System.out.println("item borrado");
            listaItems.remove(it.get());
        }
    }

    @Override
    public List<Item> traerTodos() {
        return listaItems;
    }
}
