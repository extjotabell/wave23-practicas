package com.example.clasenosql.service;

import com.example.clasenosql.entity.Producto;
import com.example.clasenosql.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> getAll() {
        Iterable<Producto> productoIterable = productoRepository.findAll();

        return StreamSupport
                .stream(productoIterable.spliterator(), false)
                .toList();
    }

    @Override
    public List<Producto> findByType(String type) {
        return productoRepository.findByType(type);
    }

    @Override
    public List<Producto> findByPriceByRange(Double price) {
        return productoRepository.findByPriceGreatherThan(price);
    }

    @Override
    public List<Producto> findByNames(String nombre) {
        return productoRepository.findByNames(nombre);
    }
}
