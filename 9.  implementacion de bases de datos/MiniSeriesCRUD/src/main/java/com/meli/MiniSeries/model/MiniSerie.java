package com.meli.MiniSeries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Double rating;

    private int amountOfAwards;

    public MiniSerie(String name, Double rating, int amountOfAwards) {
        this.name = name;
        this.rating = rating;
        this.amountOfAwards = amountOfAwards;
    }
}
