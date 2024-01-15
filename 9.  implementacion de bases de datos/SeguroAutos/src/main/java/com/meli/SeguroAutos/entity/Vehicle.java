package com.meli.SeguroAutos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_vehicle")
    private Long id;
    private String patent;
    private String brand;
    private String model;
    @Column(name = "year_of_production")
    private LocalDate yearOfProduction;
    @Column(name = "number_of_wheels")
    private int numberOfWheels;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Accident> accidents;
}
