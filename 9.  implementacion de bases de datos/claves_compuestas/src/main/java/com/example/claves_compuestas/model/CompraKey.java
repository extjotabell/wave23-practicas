package com.example.claves_compuestas.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

public class CompraKey implements Serializable {
    private int id;
    private int canastillo_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraKey compraKey = (CompraKey) o;
        return id == compraKey.id && canastillo_id == compraKey.canastillo_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, canastillo_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCanastillo_id() {
        return canastillo_id;
    }

    public void setCanastillo_id(int canastillo_id) {
        this.canastillo_id = canastillo_id;
    }
}
