package com.example.productosnosql.service;

import com.example.productosnosql.entity.Producto;
import com.example.productosnosql.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }
    public List<Producto> getAll(){
        Iterable<Producto> productoIterable = productoRepository.findAll();

        List<Producto> productoList = StreamSupport
                .stream(productoIterable.spliterator(), false)
                .collect(Collectors.toList());

        return productoList;
    }
    public List<Producto> findByNames(String nombre){ return  productoRepository.findByNames(nombre);}
}
