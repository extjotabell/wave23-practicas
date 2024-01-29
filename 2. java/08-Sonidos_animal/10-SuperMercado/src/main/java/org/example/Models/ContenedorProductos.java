package org.example.Models;

import factories.TipoExcepcion;
import interfaces.CRUD;

public class ContenedorProductos extends CRUD<Producto> {

    public ContenedorProductos() {
        super(TipoExcepcion.PRODUCTO_EXCEPCION);
    }
}
