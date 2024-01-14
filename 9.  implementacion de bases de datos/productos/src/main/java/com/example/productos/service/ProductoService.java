package com.example.productos.service;

import com.example.productos.model.Producto;
import com.example.productos.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductoService {

    @Autowired
    IProductoRepository repository;

    public List<Producto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Producto save(Producto producto) {
        repository.save(producto);
        return producto;
    }

    public Producto modify(Producto producto) {
        Producto productoAntiguo = StreamSupport.stream(repository.findAll().spliterator(), false)
                .filter(empleado -> empleado.getNombre().equals(producto.getNombre()))
                .findFirst()
                .orElse(null);

        productoAntiguo.setNombre(producto.getNombre());
        productoAntiguo.setTipo(producto.getTipo());
        productoAntiguo.setPrecio(producto.getPrecio());
        productoAntiguo.setCantidad(producto.getCantidad());

        repository.save(productoAntiguo);
        return producto;
    }
}
