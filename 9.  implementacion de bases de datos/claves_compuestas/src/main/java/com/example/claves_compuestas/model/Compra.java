package com.example.claves_compuestas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private int id;

    @Id
    private int canastillo_id;

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
