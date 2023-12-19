package com.ospina.socialmeli.repository;

import java.util.Optional;

public interface CrudRepository<T, ID> {
    T create(T entity);
    Optional<T> read(ID id);
    void update(T entity);
    void delete(ID id);
}
