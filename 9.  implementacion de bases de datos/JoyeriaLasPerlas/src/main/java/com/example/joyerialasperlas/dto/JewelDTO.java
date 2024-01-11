package com.example.joyerialasperlas.dto;


import lombok.Data;

@Data
public class JewelDTO {
  private Long id;
  private String name;
  private String material;
  private Double weight;
  private String particularity;
  private boolean haveStone;
  private boolean onSale;
}
