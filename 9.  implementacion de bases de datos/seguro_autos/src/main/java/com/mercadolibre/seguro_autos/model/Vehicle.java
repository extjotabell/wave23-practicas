package com.mercadolibre.seguro_autos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patent;
    private String brand;
    private String model;
    private Integer yearProduction;
    private Integer numberWheels;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Sinister> sinisters;
}
