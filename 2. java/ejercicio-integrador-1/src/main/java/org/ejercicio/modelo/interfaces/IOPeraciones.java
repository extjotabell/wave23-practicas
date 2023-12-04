package org.ejercicio.modelo.interfaces;

public interface IOPeraciones<T,C> {
    boolean guardar(T elemento);
    void mostrar();
    boolean eliminar(T elemento);
    void actualizar(T elemento);
    T encontrarPorId(C id);
}
