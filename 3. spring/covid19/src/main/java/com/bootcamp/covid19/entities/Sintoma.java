package com.bootcamp.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sintoma {

    protected Integer codigo, nivelGravedad;
    protected String nombre;

}
