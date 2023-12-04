package org.example.repositorio;

import org.example.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImplementacion  implements CRUDRepositorio<Factura> {

    List <Factura> listaFacturas = new ArrayList<>();

    @Override
    public void save(Factura objeto) {
        ClienteImplemenctacion cli = new ClienteImplemenctacion();

        if(cli.buscar(objeto.getCli().getDni()).isEmpty()){
            System.out.println("Agrege el cliente a la lista antes de agregar la factura");
        }else{
            listaFacturas.add(objeto);
        }

    }

    @Override
    public void mostrarPantalla() {
        for (Factura factura : listaFacturas) {
            System.out.println(factura.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(int codigoBuscado) {

        boolean encontrado = false;
        for (Factura f : listaFacturas) {
            if (f.getCodigo() == codigoBuscado) {
                System.out.println("Factura: ");
                System.out.println(f);
                return Optional.of(f);
            }
        }

        if (!encontrado) {
            System.out.println("Factura no encontrada");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(int codigoBorrado) {
        Optional<Factura> fact = this.buscar(codigoBorrado);

        if (fact.isEmpty()) {
            System.out.println("No se encontró la factura a borrar");
        }
        else {
            System.out.println("Factura borrada ");
            listaFacturas.remove(fact.get());
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}
