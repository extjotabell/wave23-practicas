package com.ejercicio.covid19.dto.response;

import com.ejercicio.covid19.entities.TypeSeverity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SyntomDto {
    private TypeSeverity severity;
}
