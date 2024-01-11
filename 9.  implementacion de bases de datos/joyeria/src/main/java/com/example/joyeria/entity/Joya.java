package com.example.joyeria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long nro_identificatorio;
    @Column
    String nombre;
    @Column
    String material;
    @Column
    Long peso;
    @Column
    String particularidad;
    @Column
    String posee_piedra;
    @Column
    boolean ventaONo;

}
