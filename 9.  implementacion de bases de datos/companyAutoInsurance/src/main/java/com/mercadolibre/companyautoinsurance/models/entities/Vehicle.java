package com.mercadolibre.companyautoinsurance.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patentVehicles;
    private String brandVehicles;
    private String modelVehicles;
    private Integer yearBuildVehicles;
    private Integer quantityWheelsVehicles;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Accident> accidents;
}
