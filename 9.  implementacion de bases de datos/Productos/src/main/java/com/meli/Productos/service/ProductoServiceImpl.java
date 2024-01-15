package com.meli.Productos.service;

import com.meli.Productos.dto.ProductoDto;
import com.meli.Productos.entity.Producto;
import com.meli.Productos.exception.NotFoundException;
import com.meli.Productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductoServiceImpl implements ProductoService {

    ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<ProductoDto> findAll() {
        Iterable<Producto> productos = repository.findAll();

        return StreamSupport.stream(productos.spliterator(), false)
            .map(ProductoDto::new)
            .toList();
    }

    @Override
    public ProductoDto findById(String id) {
        Producto producto = repository.findById(id).orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        return new ProductoDto(producto);
    }

    @Override
    public ProductoDto save(ProductoDto empleado) {
        Producto productoToSave = new Producto(empleado);
        Producto productoSaved = repository.save(productoToSave);
        return new ProductoDto(productoSaved);
    }

    @Override
    public void deleteById(String id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        repository.deleteById(id);
    }
}
