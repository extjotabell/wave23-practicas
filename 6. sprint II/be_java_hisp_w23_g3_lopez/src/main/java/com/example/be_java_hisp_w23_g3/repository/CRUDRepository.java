package com.example.be_java_hisp_w23_g3.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T, ID> {
    T create(T entity);
    List<T> createAll(List<T> entities);
    Optional<T> read(ID id);
    void update(ID id, T entity);
    void delete(ID id);
}
