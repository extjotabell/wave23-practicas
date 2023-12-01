package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    int id;
    List<Auto> lista = new ArrayList<>();

    public Garage(int id, List<Auto> lista) {
        this.id = id;
        this.lista = lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Auto> getLista() {
        return lista;
    }

    public void setLista(List<Auto> lista) {
        this.lista = lista;
    }
}
