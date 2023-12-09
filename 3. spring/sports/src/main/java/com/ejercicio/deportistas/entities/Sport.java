package com.ejercicio.deportistas.entities;

import lombok.Data;

import java.util.Objects;

@Data
public class Sport {
    private String name;
    private String level;

    public Sport(String nombre, String nivel) {
        this.name = nombre;
        this.level = nivel;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name + level);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sport sport = (Sport) obj;
        return Objects.equals(name + level, sport.name + sport.level);
    }

    @Override
    public String toString() {
        return "Sport{" +
                "nombre='" + name + '\'' +
                ", nivel='" + level + '\'' +
                '}';
    }
}
