package com.mercadolibre.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_id;
    private String nombre;
    private String material;
    private float peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean venta_o_no;
}
