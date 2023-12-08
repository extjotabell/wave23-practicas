package com.deportista.ejercicio.entities;

public class Sport {
    private String name, level;

    public Sport() {
    }

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
