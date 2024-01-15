package com.example.InsuranceCompany.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehiclePatentBrandLoss {
    private String patent;
    private String brand;
    private Double model;
    private Double economicLoss;
}
