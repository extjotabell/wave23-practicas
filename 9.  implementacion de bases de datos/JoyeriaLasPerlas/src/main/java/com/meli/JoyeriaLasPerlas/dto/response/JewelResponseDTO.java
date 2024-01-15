package com.meli.JoyeriaLasPerlas.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JewelResponseDTO {
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
