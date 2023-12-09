package com.ejercicio.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Data
@ToString
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String surname;
    private Byte age;

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(getId(), person.getId());
    }
}
