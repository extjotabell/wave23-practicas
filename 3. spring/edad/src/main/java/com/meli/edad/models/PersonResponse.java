package com.meli.edad.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonResponse {
    @Getter
    private static List<PersonResponse> personsList = new ArrayList<>();

    private String name;
    private String lastName;

    private int age;
    private LocalDate birthDate;

    public PersonResponse(String name, String lastName, LocalDate birthDate, int age) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;

        personsList.add(this);
    }
}
