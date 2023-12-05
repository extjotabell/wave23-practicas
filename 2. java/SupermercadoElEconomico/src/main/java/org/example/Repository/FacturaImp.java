package org.example.Repository;

import org.example.Modelo.Cliente;
import org.example.Modelo.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura>{

    List<Factura> listFacturas = new ArrayList<>();

    @Override
    public void save(Factura obj) {
        listFacturas.add(obj);
    }

    @Override
    public void mostrarPantalla() {
        listFacturas.stream().map(factura -> {
            return "Factura " + factura.getCodigo() + factura.toString();
        }).forEach(System.out::println);
    }

    @Override
    public void buscar(String codigo) {
        Optional<Factura> facturaEncontrado =  listFacturas.stream().filter(cliente -> cliente.getCodigo().equals(codigo)).findFirst();
        facturaEncontrado.ifPresentOrElse(factura -> {
            System.out.println("Factura encontrada, sus datos son: ");
            System.out.println(factura.toString());
        }, () -> System.out.println("No se encontro la factura"));
    }

    @Override
    public void eliminar(String codigo) {
        listFacturas = listFacturas.stream().filter(factura -> !factura.getCodigo().equals(codigo)).toList();
    }

    @Override
    public List<Factura> traerTodos() {
        return listFacturas;
    }
}
