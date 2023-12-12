package com.covid19.covid19.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Persona {
    private Integer id = 0;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintoma> sintomas;
}
