package com.example.be_java_hisp_w23_g3.repository;

import java.util.Optional;

public interface CrudRepository<T, ID> {
    void create(T entity);
    Optional<T> read(ID id);
    void update(T entity);
    void delete(ID id);
}
