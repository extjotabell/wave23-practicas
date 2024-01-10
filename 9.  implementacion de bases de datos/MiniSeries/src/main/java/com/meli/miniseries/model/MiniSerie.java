package com.meli.miniseries.model;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import lombok.Data;

@Entity
@Data
public class MiniSerie {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    @Column(name="amount_of_awards")
    private Integer amountOfAwards;

}
