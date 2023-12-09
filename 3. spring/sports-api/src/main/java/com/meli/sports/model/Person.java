package com.meli.sports.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
