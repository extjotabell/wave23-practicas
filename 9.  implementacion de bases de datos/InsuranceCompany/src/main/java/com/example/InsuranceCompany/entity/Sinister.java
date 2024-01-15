package com.example.InsuranceCompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "sinister")
public class Sinister {
    @Id
    // The database automatically assigns a unique value to the primary key column when inserting a new record.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_incident")
    private LocalDate dateOfIncident;

    @Column(name = "economic_loss")
    private Double economicLoss;
    // Indicates that several accidents can be associated with a single vehicle.

    @ManyToOne
    // Used to specify the column in the Sinister table that will contain the foreign keys that reference the vehicle.
    @JoinColumn(name = "reported_vehicle_id")
    private Vehicle reportedVehicle;

}
