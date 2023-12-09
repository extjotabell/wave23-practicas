package com.ejercicio.Deportistas.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class PersonaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
