package org.ejercicio.joyeria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Jewerly {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty("nro_identification")
    private Long nroIdentification;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    @JsonProperty("has_stone")
    private Boolean hasStone;
    private Boolean saleOrNot;
}
