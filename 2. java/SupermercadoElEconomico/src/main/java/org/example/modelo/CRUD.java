package org.example.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class CRUD<T> {
    protected List<T> entidades = new ArrayList<>();

    public CRUD(List<T> entidades) {
        this.entidades = entidades;
    }

    public void agregar(T entidad) {
        entidades.add(entidad);
    }

    public void eliminar(T entidad) {
        entidades.remove(entidad);
    }

    public void modificar(T entidad) {
        entidades.set(entidades.indexOf(entidad), entidad);
    }

    public List<T> consultar() {
        return entidades;
    }

}
