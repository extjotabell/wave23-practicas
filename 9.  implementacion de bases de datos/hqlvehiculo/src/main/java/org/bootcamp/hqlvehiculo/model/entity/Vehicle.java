package org.bootcamp.hqlvehiculo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "vehicles")
@Getter @Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "licence_plate")
    private String licencePlate;

    private String brand;
    private String model;
    private Integer year;
    private Integer wheels;

    @OneToMany(mappedBy = "vehicle")
    private Set<Accident> accidents;

}
