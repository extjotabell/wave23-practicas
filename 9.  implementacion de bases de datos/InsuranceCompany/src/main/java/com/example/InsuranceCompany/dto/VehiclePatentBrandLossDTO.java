package com.example.InsuranceCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclePatentBrandLossDTO {
    private String patent;
    private String brand;
    private Double model;
    private Double economicLoss;
}
