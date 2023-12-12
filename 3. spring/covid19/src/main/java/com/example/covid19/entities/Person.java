package com.example.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private int id;
    private String name;
    private String lastName;
    private int age;
}


