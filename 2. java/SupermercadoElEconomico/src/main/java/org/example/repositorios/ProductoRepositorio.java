package org.example.repositorios;

import org.example.modelo.CRUD;
import org.example.modelo.Producto;

import java.util.List;

public class ProductoRepositorio extends CRUD<Producto> {

    public ProductoRepositorio(List<Producto> productos) {
        super(productos);
    }

    public Producto consultarPorId(int id) {
        return consultar().stream().filter(producto -> producto.getCodigo() == id).findFirst().orElse(null);
    }
}
