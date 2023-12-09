package com.ejercicio.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Data
@ToString
@AllArgsConstructor
public class Syntom {
    private Integer code;
    private String name;
    private TypeSeverity typeSeverity;

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Syntom syntom = (Syntom) obj;
        return Objects.equals(getCode(), syntom.getCode());
    }
}
