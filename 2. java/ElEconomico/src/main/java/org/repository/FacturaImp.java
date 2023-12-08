package org.repository;

import org.bootcamp.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements ICRUDRepository<Factura> {

    List<Factura> facturas = new ArrayList<Factura>();

    @Override
    public void save(Factura objeto) {
        facturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        facturas.forEach(System.out::println);
    }

    @Override
    public Optional<Factura> buscar(Long numero) {
        boolean bandera = false;
        for (Factura factura : facturas){
            if (factura.getNumero_factura().equals(numero)){
                System.out.println(factura);
                return Optional.of(factura);
            }
        }

        if (bandera == false){
            System.out.println("Factura no encontrada.");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long numero) {
        Optional<Factura> factura = this.buscar(numero);

        if(factura.isEmpty()){
            System.out.println("No se encontro la factura a borrar.");
        }
        else{
            System.out.println("Factura borrada correctamente.");
            facturas.remove(factura.get());
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return facturas;
    }

}
