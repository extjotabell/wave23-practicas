package models;

import factories.TipoExcepcion;
import interfaces.CRUD;

public class ContenedorClientes extends CRUD<Cliente> {
    public ContenedorClientes() {
        super(TipoExcepcion.CLIENTE_EXCEPCION);
    }
}
