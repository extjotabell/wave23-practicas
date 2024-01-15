package com.example.InsuranceCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclePatentBrandModelDTO {
    private String patent;
    private String brand;
    private String model;
}
