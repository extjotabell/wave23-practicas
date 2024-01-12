package com.example.relacionesJPA.entities.claveCompuesta2;

import com.example.relacionesJPA.entities.claveCompuesta.PersonaKey;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class CompraKey implements Serializable {
    private Integer id;
    private Integer fecha;

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
