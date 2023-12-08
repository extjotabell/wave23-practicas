package com.spring.covid19.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonaDto {
    private String nombre, apellido;
}