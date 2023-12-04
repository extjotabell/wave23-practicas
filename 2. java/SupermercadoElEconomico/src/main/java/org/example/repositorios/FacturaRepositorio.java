package org.example.repositorios;

import org.example.modelo.CRUD;
import org.example.modelo.Factura;

import java.util.List;

public class FacturaRepositorio extends CRUD<Factura> {

    public FacturaRepositorio(List<Factura> entidades) {
        super(entidades);
    }
}
