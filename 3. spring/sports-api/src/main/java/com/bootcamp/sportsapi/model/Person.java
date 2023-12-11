package com.bootcamp.sportsapi.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private long id;
    private String name;
    private String lastName;
    private int age;
    private List<Sport> sports;
}
