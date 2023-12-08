package com.deportista.ejercicio.dto;

public class SportDTO {
    private String name, sportLevel;

    public SportDTO() {
    }

    public SportDTO(String name, String sportLevel) {
        this.name = name;
        this.sportLevel = sportLevel;
    }

    public void setSportLevel(String sportLevel) {
        this.sportLevel = sportLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSportLevel() {
        return sportLevel;
    }
}
