package org.bootcamp.productos.service;

import org.bootcamp.productos.model.entity.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> getAll();

    Producto save(Producto producto);

    Producto update(Producto producto);

}
