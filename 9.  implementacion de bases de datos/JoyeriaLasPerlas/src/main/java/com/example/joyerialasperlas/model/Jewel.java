package com.example.joyerialasperlas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Joya {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "nro_identificatorio")
  private Long id;
  @Column(name = "nombre")
  private String name;
  @Column(name = "material")
  private String material;
  @Column(name = "peso")
  private Double weight;
  @Column(name = "particularidad")
  private String particularity;
  @Column(name = "posee_pieda")
  private boolean haveStone;
  @Column(name = "venta_o_no")
  private boolean onSale;
}
