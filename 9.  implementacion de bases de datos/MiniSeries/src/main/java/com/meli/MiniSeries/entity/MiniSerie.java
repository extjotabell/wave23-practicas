package com.meli.MiniSeries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mini_serie")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name_serie", length = 50)
    private String name;

    @Column(name = "rating_serie")
    private Double rating;

    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
