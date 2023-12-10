package com.spring.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeportistaDto {
    private String nombrePersona, apellido, nombreDeporte;
}
