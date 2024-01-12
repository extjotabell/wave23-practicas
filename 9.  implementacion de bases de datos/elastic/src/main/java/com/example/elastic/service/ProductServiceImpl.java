package com.example.elastic.service;

import com.example.elastic.entity.Producto;
import com.example.elastic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public String save(Producto producto) {
        repository.save(producto);
        return "Se agrego";
    }

    @Override
    public List<Producto> getAll() {
        Iterable<Producto> productos =repository.findAll();
        return StreamSupport
                .stream(productos.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Producto update(String id, Producto producto) {
        Producto actualizado = repository.findById(id).orElse(null);
        actualizado.setNombre(producto.getNombre());
        actualizado.setTipo(producto.getTipo());
        actualizado.setCantidad(producto.getCantidad());
        actualizado.setPrecio(producto.getPrecio());
        repository.save(actualizado);
        return actualizado;
    }


}
