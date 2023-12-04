package org.example.repository;

import org.example.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioProducto implements CRUDRepository<Producto> {
    private final List<Producto> productos;

    public RepositorioProducto() {
        this.productos = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public Producto create(Producto entity) {
        productos.add(entity);
        return entity;
    }

    @Override
    public Optional<Producto> read(int id) {
        return productos.stream().filter(producto -> producto.getId() == id).findFirst();
    }

    @Override
    public Producto update(int id, Producto entity) {
        Optional<Producto> producto = read(id);

        producto.ifPresent(value -> {
            value.setNombre(entity.getNombre());
            value.setCosto(entity.getCosto());
        });
        return producto.orElse(null);
    }

    @Override
    public void delete(int id) {
        Optional<Producto> producto = read(id);
        producto.ifPresent(productos::remove);
    }

    @Override
    public void listAll() {
        productos.forEach(System.out::println);
    }
}
