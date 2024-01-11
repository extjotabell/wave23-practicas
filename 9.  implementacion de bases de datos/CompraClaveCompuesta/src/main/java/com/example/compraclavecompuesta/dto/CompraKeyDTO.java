package com.example.compraclavecompuesta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompraKeyDTO implements Serializable {

  @JsonProperty("cliente_id")
  private Integer clientId;
  @JsonProperty("fecha")
  private Date date;
}
