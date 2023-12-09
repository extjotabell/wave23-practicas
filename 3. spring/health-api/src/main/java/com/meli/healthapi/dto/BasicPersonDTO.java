package com.meli.healthapi.dto;

public class BasicPersonDTO {
    private String name;
    private String lastName;

    public BasicPersonDTO(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
