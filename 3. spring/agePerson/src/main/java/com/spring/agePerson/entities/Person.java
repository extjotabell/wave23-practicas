package com.spring.agePerson.entities;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String nombre;

    private Integer age;

    private LocalDate birthDate;

    public Person(String nombre, LocalDate birthDate) {
        this.nombre = nombre;
        this.birthDate = birthDate;
        this.age = this.calculateAge();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    private int calculateAge(){
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.birthDate, today);
        return period.getYears();
    }
}
