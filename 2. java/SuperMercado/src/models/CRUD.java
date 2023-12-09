package models;

import java.util.ArrayList;
import java.util.List;

public abstract class CRUD<T> {
    protected List<T> entities = new ArrayList<>();

    public CRUD(List<T> entities) {
        this.entities = entities;
    }

    public void add(T entity) {
        entities.add(entity);
    }

    public void delete(T entity) {
        entities.remove(entity);
    }

    public void update(T entity) {
        entities.set(entities.indexOf(entity), entity);
    }

    public List<T> consult() {
        return entities;
    }

}