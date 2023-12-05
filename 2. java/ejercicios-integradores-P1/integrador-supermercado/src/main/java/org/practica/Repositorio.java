package org.practica;

public interface Repositorio <T>{
    void create(T resource);
    void remove(T resource);
    void update(T resource);
    T getById(int id);
}
