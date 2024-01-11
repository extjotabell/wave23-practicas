package com.meli.MiniSeries.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "amounth_of_awards")
    private int amountOfAwards;
}
