package org.example.CRUD;

import java.util.List;

public interface CRUD<T> {
    T create(T obj);
    void delete(T obj);
    T read(Long id);
    List<T> findAll();
}
