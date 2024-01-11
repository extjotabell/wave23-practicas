package com.ejercicio.joyeria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private int nroIdentificatorio;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    @Column(name = "venta_o_no")
    @JsonProperty("venta_o_no")
    private boolean ventaONo = true;
}
