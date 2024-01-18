package com.example.ejercicioProductosNoSQL.service.impl;

import com.example.ejercicioProductosNoSQL.dto.MessageDto;
import com.example.ejercicioProductosNoSQL.dto.ProductoDto;
import com.example.ejercicioProductosNoSQL.model.Producto;
import com.example.ejercicioProductosNoSQL.repository.IProductoRepository;
import com.example.ejercicioProductosNoSQL.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public MessageDto save(ProductoDto productoDto) {
        productoRepository.save(new Producto(
                productoDto.getId(),
                productoDto.getNombre(),
                productoDto.getTipo(),
                productoDto.getPrecioVenta(),
                productoDto.getPrecioCosto(),
                productoDto.getCantidad()
        ));
        return new MessageDto("Ok");
    }

    @Override
    public List<ProductoDto> findAll() {
        List<Producto> productoList = StreamSupport.stream(
                        productoRepository.findAll().spliterator(), false)
                .toList();

        return productoList.stream()
                .map(p -> new ProductoDto(
                        p.getId(),
                        p.getNombre(),
                        p.getTipo(),
                        p.getPrecioVenta(),
                        p.getPrecioCosto(),
                        p.getCantidad()
                )).toList();
    }
}
