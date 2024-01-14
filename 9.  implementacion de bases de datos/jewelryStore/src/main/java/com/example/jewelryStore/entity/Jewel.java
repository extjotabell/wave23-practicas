package com.example.jewelryStore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="jewelry")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long id;
    @Column(name = "nombre")
    private String name;
    private String material;
    @Column(name = "peso")
    private Double weight;
    @Column(name = "particularidad")
    private String particularity;
    @Column(name = "posee_piedra")
    private Boolean hasStone;
    @Column(name = "venta_o_no")
    private Boolean saleOrNot;
}
