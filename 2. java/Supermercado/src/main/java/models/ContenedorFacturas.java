package models;

import Exceptions.ElementNotFoundException;
import Exceptions.FacturaNotFoundException;
import interfaces.interfaceCRUD;

import java.util.ArrayList;
import java.util.List;

public class ContenedorFacturas implements interfaceCRUD<Factura> {

    private List<Factura> facturas;

    @Override
    public Factura getById(String id) throws ElementNotFoundException {
        return facturas.stream().filter(factura -> factura.getId().equalsIgnoreCase(id))
                .findFirst().orElseThrow(() -> new FacturaNotFoundException(id));
    }

    @Override
    public boolean delete(String id) {
        try {
            Factura factura = getById(id);
            return facturas.remove(factura);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void add(Factura element) {
        if (facturas.contains(element)) {
            System.out.println("La factura ya se encuentra registrada");
        } else {
            facturas.add(element);
            System.out.println("Se ha registrada la factura correctamente");
        }
    }

    @Override
    public void showAll() {
        System.out.println("\nMostrando facturas:");
        facturas.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void showById(String id) {
        try {
            Factura factura = getById(id);
            System.out.println(factura);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public ContenedorFacturas() {
        facturas = new ArrayList<>();
    }
}
