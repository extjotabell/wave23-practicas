package com.example.seguroautos.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinisterDTO {
  private Long id;
  private Date date;
  private Double economicLoss;
  private VehicleDTO vehicle;
}
