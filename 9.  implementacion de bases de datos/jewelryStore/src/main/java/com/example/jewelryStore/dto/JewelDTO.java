package com.example.jewelryStore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JewelDTO {
    @JsonProperty("nro_identificatorio")
    private Long id;
    @JsonProperty("nombre")
    private String name;
    private String material;
    @JsonProperty("peso")
    private Double weight;
    @JsonProperty("particularidad")
    private String particularity;
    @JsonProperty("posee_piedra")
    private Boolean hasStone;
    @JsonProperty("venta_o_no")
    private Boolean saleOrNot;
}
