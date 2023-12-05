package ejercicio_integrador;

import java.util.List;

public interface CRUD <T>{
    void create(T o);
    List<T> getAll();
    T findById();
    void update(T o);
    void delete(T id);

}
