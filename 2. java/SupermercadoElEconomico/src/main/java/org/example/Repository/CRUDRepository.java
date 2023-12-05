package org.example.Repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository <T>{
    public void save (T obj);
    public void mostrarPantalla();
    public void buscar (String id);
    public void eliminar (String id);
    public List<T> traerTodos();
}
