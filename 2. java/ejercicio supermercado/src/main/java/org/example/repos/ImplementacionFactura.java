package org.example.repos;

import org.example.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImplementacionFactura implements IConsultable<Factura>{
    ArrayList<Factura> facturas = new ArrayList<>();
    @Override
    public void guardar(Factura objeto) {
        facturas.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Factura f : facturas) {
            System.out.println("Cliente" + f.getCliente());
            System.out.println("Items" + f.getItems());
            System.out.println("Total" + f.getTotalCompta());
        }
    }

    @Override
    public Optional<Factura> buscar(Long id) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public void buscarEliminarPorNombre(String nombre) {
    }

    @Override
    public List<Factura> traerTodos() {
        return null;
    }
}
