package com.deportista.ejercicio.dto;

public class UserSportDTO {
    private String name, surname, sportName;

    public UserSportDTO(String name, String surname, String sportName) {
        this.name = name;
        this.surname = surname;
        this.sportName = sportName;
    }

    public UserSportDTO() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSportName() {
        return sportName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
