package com.practice.joyeria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="nro_identificatorio")
    @JsonProperty("nro_identificatorio")
    private Long nroIdentificatorio;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name="posee_piedra")
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
    @Column(name="venta_o_no")
    @JsonProperty("venta_o_no")
    private Boolean ventaONo;

}
