package com.mercadolibre.jeweler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Jewerly {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
