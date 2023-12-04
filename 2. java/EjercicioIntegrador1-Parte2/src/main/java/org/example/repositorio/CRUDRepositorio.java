package org.example.repositorio;

import java.util.List;
import java.util.Optional;

public interface CRUDRepositorio <T>{

    public void save (T objeto);
    public void mostrarPantalla();
    public Optional<T> buscar (int id);
    public void eliminar (int id);
    public List<T> traerTodos();
}
