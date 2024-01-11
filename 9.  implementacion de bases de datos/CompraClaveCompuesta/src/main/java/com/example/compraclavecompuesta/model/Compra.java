package com.example.compraclavecompuesta.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@IdClass(CompraKey.class)
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
  @Id
  @JsonProperty("cliente_id")
  @Column(name = "clienteId")
  private Integer clientId;
  @Id
  @JsonProperty("fecha")
  @Column(name = "fecha")
  private Date date;
  @JsonProperty("precio")
  @Column(name = "precio")
  private Double price;
}
