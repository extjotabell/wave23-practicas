package com.mercadolibre.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    String name;
    String lastname;
    int age;
    Sport sport;
}
