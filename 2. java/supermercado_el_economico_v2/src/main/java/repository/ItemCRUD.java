package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemCRUD implements CRUDRepository<Item>{

    List<Item> items = new ArrayList<>();

    @Override
    public void create(Item obj) {
        items.add(obj);
    }

    @Override
    public Item read(int id) {
        return items.stream()
            .filter(i -> i.getCodigo() == id)
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Item> readAll() {
        return items;
    }

    @Override
    public void update(int id, Item obj) {
        Item item = read(id);

        item.setNombre(obj.getNombre());
        item.setPrecio(obj.getPrecio());
        item.setCantidad(obj.getCantidad());
    }

    @Override
    public void delete(int id) {
        items.removeIf(i -> i.getCodigo() == id);
    }
}
