package com.example.joyerialasperlas.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JewelCreationDTO {
  @JsonProperty("nombre")
  private String name;
  @JsonProperty("material")
  private String material;
  @JsonProperty("peso")
  private Double weight;
  @JsonProperty("particularidad")
  private String particularity;
  @JsonProperty("posee_piedra")
  private boolean haveStone;
  @JsonProperty("ventaONo")
  private boolean onSale;
}
