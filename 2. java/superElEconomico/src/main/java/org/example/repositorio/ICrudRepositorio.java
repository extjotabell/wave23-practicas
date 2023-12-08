package org.example.repositorio;
import java.util.List;
import java.util.Optional;

public interface ICrudRepositorio<T> {

    public void guardar (T objeto);
    public void mostrar();
    public Optional<T> buscar (Long id);
    public void eliminar (Long id);
    public List<T> mostrarTodos();
}
