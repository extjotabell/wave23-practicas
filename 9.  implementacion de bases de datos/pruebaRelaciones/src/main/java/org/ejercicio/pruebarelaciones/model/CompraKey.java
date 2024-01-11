package org.ejercicio.pruebarelaciones.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
public class CompraKey implements Serializable {
    private LocalDate fecha;
    private Long clientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraKey compraKey = (CompraKey) o;
        return Objects.equals(fecha, compraKey.fecha) && Objects.equals(clientId, compraKey.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, clientId);
    }
}
