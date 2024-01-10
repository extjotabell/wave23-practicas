package com.example.joyeria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long nro_identificatorio;
    String nombre;
    String material;
    Long peso;
    String particularidad;
    String posee_piedra;
    boolean ventaONo;

}
