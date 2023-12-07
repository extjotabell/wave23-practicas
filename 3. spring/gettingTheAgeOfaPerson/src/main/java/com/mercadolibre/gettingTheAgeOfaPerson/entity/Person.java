package com.mercadolibre.gettingTheAgeOfaPerson.entity;

import java.time.LocalDate;

public class Person {
    private LocalDate dateOfBirth;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
