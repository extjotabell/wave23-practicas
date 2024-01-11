package com.bootcamp.joyeria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "joyas")
@Getter @Setter
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;

    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;

    @Column(name = "venta_o_no")
    private Boolean ventaONo;
}
