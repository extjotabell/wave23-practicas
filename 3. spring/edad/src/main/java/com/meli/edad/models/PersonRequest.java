package com.meli.edad.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
public class PersonRequest {
    private String name;
    private String lastName;

    private int birthYear;
    private int birthMonth;
    private int birthDay;

    private int age;
    private LocalDate birthDate;

    public PersonRequest(String name, String lastName, int birthYear, int birthMonth, int birthDay) {
        this.name = name;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public void calculateAge() {
        this.birthDate = LocalDate.of(this.birthYear, this.birthMonth, this.birthDay);
        this.age = Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
