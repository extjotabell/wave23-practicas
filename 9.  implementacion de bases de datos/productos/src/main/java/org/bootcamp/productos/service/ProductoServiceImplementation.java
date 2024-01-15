package org.bootcamp.productos.service;

import org.bootcamp.productos.model.entity.Producto;
import org.bootcamp.productos.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductoServiceImplementation implements IProductoService{

    @Autowired
    IProductoRepository repository;


    @Override
    public List<Producto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        Producto producto_upd = StreamSupport.stream(repository.findAll().spliterator(), false)
                .filter(p -> p.getNombre().equals(producto.getNombre()))
                .findFirst()
                .get();

        producto_upd.setNombre(producto.getNombre());
        producto_upd.setTipo(producto.getTipo());
        producto_upd.setPrecio(producto.getPrecio());
        producto_upd.setPrecioCosto(producto.getPrecioCosto());
        producto_upd.setCantidad(producto.getCantidad());

        return repository.save(producto_upd);
    }

}
