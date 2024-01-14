package com.example.clasenosql.service;

import com.example.clasenosql.entity.Producto;
import com.example.clasenosql.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PorductosService {

    @Autowired
    private ProductosRepository repository;

    //agregar producto
    public Producto save(Producto producto){
        return repository.save(producto);
    }

}
