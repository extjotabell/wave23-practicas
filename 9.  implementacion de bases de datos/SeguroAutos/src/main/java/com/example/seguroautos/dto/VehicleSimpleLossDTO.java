package com.example.seguroautos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleSimpleLossDTO {
  private String patent;
  private String brand;
  private String model;
  private Double total;

}
