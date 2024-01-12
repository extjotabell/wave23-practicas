package com.example.seguroautos.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleSimpleDTO {
  private String patent;
  private String brand;
  private String model;

}
