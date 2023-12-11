package com.bootcamp.covid.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Person {
    private long id;
    private String name;
    private String lastname;
    private int age;
}
