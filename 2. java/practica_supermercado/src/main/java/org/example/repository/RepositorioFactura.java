package org.example.repository;

import org.example.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioFactura implements CRUDRepository<Factura> {
    private final List<Factura> facturas;

    public RepositorioFactura() {
        facturas = new ArrayList<>();
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    @Override
    public Factura create(Factura entity) {
        facturas.add(entity);
        return entity;
    }

    @Override
    public Optional<Factura> read(int id) {
        return facturas.stream().filter(factura -> factura.getId() == id).findFirst();
    }

    @Override
    public Factura update(int id, Factura entity) {
        Optional<Factura> factura = read(id);

        factura.ifPresent(value -> {
            value.setCliente(entity.getCliente());
            value.setProductos(entity.getProductos());
            value.setCostoTotal(entity.getCostoTotal());
        });
        return factura.orElse(null);
    }

    @Override
    public void delete(int id) {
        Optional<Factura> factura = read(id);
        factura.ifPresent(facturas::remove);
    }

    @Override
    public void listAll() {
        facturas.forEach(System.out::println);
    }
}
