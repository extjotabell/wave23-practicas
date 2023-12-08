package com.mercadolibre.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Entity class representing a person and their associated symptoms in the context of COVID-19.
 */
@Data
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String lastname;
    private Integer age;
    private List<Symptom> symptoms;
}
