package com.example.showroom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Clothes {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String code;
  private String name;
  private String brand;
  private String type;
  private String color;
  private int size;
  private String quantity;
  private double salePrice;
}
