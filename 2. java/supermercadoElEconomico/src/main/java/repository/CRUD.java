package repository;

import java.util.List;

public interface CRUD <T>{
    void agregar (T elemento);
    void eliminar (T elemento);
    void actualizar (T elementoViejo, T elementoNuevo);
    T consultar(String criterio);
    void obtenerTodos();
}
