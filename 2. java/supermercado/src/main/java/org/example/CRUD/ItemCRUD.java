package org.example.CRUD;

import org.example.entities.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemCRUD implements CRUD<Item>{

    List<Item> items = new ArrayList<>();

    /**
     * Método para dar de alta un item
     * @param item
     * @return Sí no existe, lo crea y retorna el item. Sí no, retorna null.
     */
    @Override
    public Item create(Item item) {
        System.out.println("\nCreando Item: " + item);

        if (!items.contains(item)) {
            items.add(item);
            System.out.println("Item agregado correctamente");
            return item;
        } else {
            System.out.println("El item ya se encuentra registrado");
            return null;
        }
    }

    /**
     * Método para eliminar a un item
     * @param item
     */
    @Override
    public void delete(Item item) {
        System.out.println("\nEliminando item: " + item);
        if (items.contains(item)) {
            items.remove(item);
            System.out.println("Item eliminado correctamente");
        } else {
            System.out.println("El item no se encuentra registrado");
        }
    }
    /**
     * Método para buscar un item por su codigo
     * @param codigo
     * @return Sí existe, retorna el item. Sí no, retorna null.
     */
    @Override
    public Item read(Long codigo) {
        Optional<Item> item = items.stream()
                .filter(itemRegistrado -> codigo.equals(itemRegistrado.getCodigo()))
                .findFirst();

        if (item.isEmpty()) {
            System.out.println("No se encontró un item con los datos ingresados");
            return null;
        }

        System.out.println("\nEl item solicitado es:");
        System.out.println(item.get());
        return item.get();
    }

    /**
     * Método para devolver todos los items almacenados
     */
    @Override
    public List<Item> findAll() {
        return items;
    }
}
