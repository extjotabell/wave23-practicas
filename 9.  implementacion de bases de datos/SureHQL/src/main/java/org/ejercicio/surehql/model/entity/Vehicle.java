package org.ejercicio.surehql.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patent;
    private String brand;
    private String model;
    private LocalDate yearOfProduction;
    private Integer wheels;
    @OneToMany(mappedBy = "vehicle")
    private List<Sinester> sinester;
}
