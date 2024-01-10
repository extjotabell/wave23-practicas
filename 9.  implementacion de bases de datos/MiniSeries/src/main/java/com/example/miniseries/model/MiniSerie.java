package com.example.miniseries.model;

import jakarta.persistence.*;

@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getAmountOfAwards() {
        return amountOfAwards;
    }

    public void setAmountOfAwards(int amountOfAwards) {
        this.amountOfAwards = amountOfAwards;
    }
}
