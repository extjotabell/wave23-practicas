package org.example.CRUD;

import org.example.entities.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaCRUD implements CRUD<Factura>{
    private List<Factura> facturas = new ArrayList<>();

    /**
     * Método para dar de alta una factura
     * @param factura
     * @return Sí no existe, lo crea y retorna el cliente. Sí no, retorna null.
     */
    @Override
    public Factura create(Factura factura) {
        System.out.println("\nCreando factura: " + factura);

        if (!facturas.contains(factura)) {
            facturas.add(factura);
            System.out.println("Factura creada correctamente");
            return factura;
        } else {
            System.out.println("La factura ya se encuentra registrada");
            return null;
        }
    }

    /**
     * Método para eliminar una factura
     * @param factura
     */
    @Override
    public void delete(Factura factura) {
        System.out.println("\nEliminando factura: " + factura.getId());
        if (facturas.contains(factura)) {
            facturas.remove(factura);
            System.out.println("Factura eliminada correctamente");
        } else {
            System.out.println("La factura no se encuentra registrado");
        }
    }

    /**
     * Método para buscar una factura por su id
     * @param id
     * @return Sí existe, retorna la factura. Sí no, retorna null.
     */
    @Override
    public Factura read(Long id) {
        Optional<Factura> factura = facturas.stream()
                .filter(facturaRegistrada -> id.equals(facturaRegistrada.getId()))
                .findFirst();

        if (factura.isEmpty()) {
            System.out.println("No se encontró una factura con los datos ingresados");
            return null;
        }

        System.out.println("La factura solicitada es:");
        System.out.println(factura.get());
        return factura.get();
    }

    /**
     * Método para devolver todas los facturas almacenadas
     */
    @Override
    public List<Factura> findAll() {
        return facturas;
    }
}
