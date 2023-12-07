package com.meli.deportistas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeporteDTO implements Serializable {
    @Getter
    private static List<DeporteDTO> deportes = new ArrayList<>();

    private String nombre;
    private Integer nivel;

    public DeporteDTO(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;

        deportes.add(this);
    }

}
