package com.ejercicio.Deportistas.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class DeporteDTO implements Serializable {
    private String nombre;
    private String nivel;
}
