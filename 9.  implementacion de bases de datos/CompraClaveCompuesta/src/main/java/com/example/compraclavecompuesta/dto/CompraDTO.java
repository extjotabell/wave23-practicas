package com.example.compraclavecompuesta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {

  @JsonProperty("cliente_id")
  private Integer clientId;
  @JsonProperty("fecha")
  private Date date;
  @JsonProperty("precio")
  private Double price;
}
