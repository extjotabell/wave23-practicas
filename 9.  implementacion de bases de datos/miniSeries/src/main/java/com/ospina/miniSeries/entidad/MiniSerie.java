package com.ospina.miniSeries.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "miniserie")

public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String nombre;

    Double rating;

    Integer cantidadDePremios;

    public MiniSerie(Long id, String nombre, Double rating, Integer cantidadDePremios) {
        this.id = id;
        this.nombre = nombre;
        this.rating = rating;
        this.cantidadDePremios = cantidadDePremios;
    }

    public MiniSerie() {

    }
}
