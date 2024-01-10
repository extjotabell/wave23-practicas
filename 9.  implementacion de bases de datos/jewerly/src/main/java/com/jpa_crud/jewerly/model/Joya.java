package com.jpa_crud.jewerly.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "Joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_identificatorio")
    private Long nroIdentificatorio;
    @Column(nullable = false, length = 40)
    private String nombre;
    @Column(nullable = false, length = 20)
    private String material;
    @Column(nullable = false)
    private Integer peso;
    @Column(nullable = false, length = 200)
    private String particularidad;
    @Column(name = "posee_piedra", nullable = false)
    private Boolean poseePiedra;
    @Column(nullable = false)
    private Boolean ventaONo;
}
