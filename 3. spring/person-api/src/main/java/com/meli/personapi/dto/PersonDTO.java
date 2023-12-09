package com.meli.personapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PersonDTO {
    private String name;
    private String lastName;
    private LocalDate birthDate;
}
