package com.meli.JoyeriaLasPerlas.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_identificatorio")
    private Long nroIdentification;
    @Column(name = "nombre")
    private String name;
    private String material;
    @Column(name = "peso")
    private double weight;
    @Column(name = "particularidad")
    private String particularity;
    @Column(name = "posee_piedra")
    private boolean hasStone;
    @Column(name = "ventaONo")
    private boolean saleOrNot;

}
