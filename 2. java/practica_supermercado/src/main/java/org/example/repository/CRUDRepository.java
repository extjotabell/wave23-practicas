package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {
    T create(T entity);
    Optional<T> read(int id);

    T update(int id, T entity);
    void delete(int id);
    void listAll();
    default T readNullable(int id) {
        return read(id).orElse(null);
    }
}
