package com.meli.JoyeriaLasPerlas.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JewelRequestDTO {

    @JsonProperty("nombre")
    private String name;
    @JsonProperty("material")
    private String material;
    @JsonProperty("peso")
    private double weight;
    @JsonProperty("particularidad")
    private String particularity;
    @JsonProperty("posee_piedra")
    private boolean hasStone;
    @JsonProperty("ventaONo")
    private boolean saleOrNot;

}
