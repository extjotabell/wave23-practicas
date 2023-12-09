package com.meli.personapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor

public class PersonResponseDTO {
        private String name;
        private String lastName;
        private int age;
    }