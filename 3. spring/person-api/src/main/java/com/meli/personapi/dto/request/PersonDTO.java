package com.meli.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PersonDTO {
    private String name;
    private String lastName;
    private int year;
    private int month;
    private int day;

}
