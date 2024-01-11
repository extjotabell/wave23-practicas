package com.meli.Joyeria.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty("nro_identificatorio")
    private Long id;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;

    private Boolean ventaONo;

    public Joya(String nombre, String material, Double peso, String particularidad, Boolean poseePiedra, Boolean ventaONo) {
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.poseePiedra = poseePiedra;
        this.ventaONo = ventaONo;
    }
}
