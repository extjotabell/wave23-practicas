package com.bootcamp.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SintomaDTO {

    protected String nombre;
    protected Integer nivelGravedad;

}
