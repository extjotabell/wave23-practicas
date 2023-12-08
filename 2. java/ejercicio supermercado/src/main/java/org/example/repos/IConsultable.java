package org.example.repos;

import java.util.List;
import java.util.Optional;

public interface IConsultable <T> {
    public void guardar (T objeto);
    public void mostrar();
    public Optional<T> buscar (Long id);
    public void eliminar (Long id);

    public void buscarEliminarPorNombre(String nombre);
    public List<T> traerTodos();
}
