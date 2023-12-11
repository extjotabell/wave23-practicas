package com.bootcamp.deportistas.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeporteDTO {

    protected String nombre;
    protected Integer nivel;

    @Getter
    protected static List<DeporteDTO> deportes = new ArrayList<>();

    public DeporteDTO(String nombre, Integer nivel){
        this.nombre = nombre;
        this.nivel =nivel;

        deportes.add(this);
    }
}
