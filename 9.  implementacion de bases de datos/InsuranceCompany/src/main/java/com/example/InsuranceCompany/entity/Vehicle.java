package com.example.InsuranceCompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    // The database automatically assigns a unique value to the primary key column when inserting a new record.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patent;

    private String brand;

    private String model;

    @Column(name = "year_of_production")
    private Integer yearOfProduction;

    @Column(name = "number_of_wheels")
    private Integer numberOfWheels;
}
