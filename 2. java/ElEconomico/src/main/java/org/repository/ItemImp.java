package org.repository;

import org.bootcamp.Factura;
import org.bootcamp.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements ICRUDRepository<Item> {

    List<Item> items = new ArrayList<>();

    @Override
    public void save(Item objeto) {
        items.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        items.forEach(System.out::println);
    }

    @Override
    public Optional<Item> buscar(Long codigo) {
        boolean bandera = false;
        for (Item item : items){
            if (item.getCodigo().equals(codigo)){
                System.out.println(item);
                return Optional.of(item);
            }
        }

        if (bandera == false){
            System.out.println("Factura no encontrada.");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigo) {
        Optional<Item> item = this.buscar(codigo);

        if(item.isEmpty()){
            System.out.println("No se encontro la factura a borrar.");
        }
        else{
            System.out.println("Factura borrada correctamente.");
            items.remove(item.get());
        }
    }

    @Override
    public List<Item> traerTodos() {
        return items;
    }

    public double calcularTotal(){
        return items.stream()
                .mapToDouble(item -> {
                    return item.getPrecio_unitario() * item.getCantidad();
                })
                .sum();
    }

}
