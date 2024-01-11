package com.mercadolibre.compras.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CompraKey implements Serializable {
    private Integer id;
    private LocalDate fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraKey compraKey = (CompraKey) o;
        return Objects.equals(id, compraKey.id) && Objects.equals(fecha, compraKey.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha);
    }
}
