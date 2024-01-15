package com.meli.SeguroAutos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_accident")
    private Long id;
    @Column(name = "date_of_accident")
    private LocalDate dateOfAccident;
    @Column(name = "economic_losses")
    private Double economicLosses;
    @ManyToOne
    @JoinColumn(name = "id_vehicle", nullable = false)
    private Vehicle vehicle;
}
