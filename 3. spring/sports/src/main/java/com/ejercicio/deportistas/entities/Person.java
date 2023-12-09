package com.ejercicio.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private Integer edad;

    @Override
    public int hashCode() {
        return Objects.hash(name + surname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name + surname, person.name + person.surname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", edad=" + edad +
                '}';
    }
}
