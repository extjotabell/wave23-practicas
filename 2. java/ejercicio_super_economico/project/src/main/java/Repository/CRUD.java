package Repository;

import java.util.List;
import java.util.Optional;

public interface CRUD <T>{
    public void guardar(T objeto);
    public void mostrar();
    public Optional<T> buscar (int id);
    public List<T> buscarTods();
    public void eliminar(int id);
}
