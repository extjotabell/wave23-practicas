package com.meli.personapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private int age;
}

