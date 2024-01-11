package com.example.joyerialasperlas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Table(name = "Joya")
public class Jewel {

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

  public Jewel(String name, String material, Double weight, String particularity, boolean haveStone,
      boolean onSale) {
    this.name = name;
    this.material = material;
    this.weight = weight;
    this.particularity = particularity;
    this.haveStone = haveStone;
    this.onSale = onSale;
  }

  public Jewel() {

  }
}
