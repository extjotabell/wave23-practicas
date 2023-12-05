package org.example.Repository;

import org.example.Modelo.Factura;
import org.example.Modelo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDRepository<Item> {

    List<Item> listItem = new ArrayList<>();

    @Override
    public void save(Item obj) {
        listItem.add(obj);
    }

    @Override
    public void mostrarPantalla() {
        listItem.stream().map(item -> {
            return "Item " + item.getCodigo() + item.toString();
        }).forEach(System.out::println);
    }

    @Override
    public void buscar(String codigo) {
        Optional<Item> itemEncontrado =  listItem.stream().filter(item -> item.getCodigo().equals(codigo)).findFirst();
        itemEncontrado.ifPresentOrElse(item -> {
            System.out.println("Item encontrado, sus datos son: ");
            System.out.println(item.toString());
        }, () -> System.out.println("No se encontro el item."));
    }

    @Override
    public void eliminar(String codigo) {
        listItem = listItem.stream().filter(item -> !item.getCodigo().equals(codigo)).toList();
    }

    @Override
    public List<Item> traerTodos() {
        return listItem;
    }

    public double totalCompra(){
        return listItem.stream().map(item -> item.getcostoUnitario() * item.getCantidad()).mapToDouble(Double::valueOf).sum();
    }
}
