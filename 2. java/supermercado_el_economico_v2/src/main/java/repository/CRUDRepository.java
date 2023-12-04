package repository;

import java.util.List;

public interface CRUDRepository<T> {
    void create(T obj);
    T read(int id);
    List<T> readAll();
    void update(int id, T obj);
    void delete(int id);
}
