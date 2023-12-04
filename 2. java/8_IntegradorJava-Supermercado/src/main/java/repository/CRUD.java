package repository;

import java.util.List;

public interface CRUD<T> {
    public void alta(T obj);
    public void baja(String id);
    public T buscarPorId(String id);
    public List<T> obtenerTodos();

}
