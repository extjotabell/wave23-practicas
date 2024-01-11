package com.meli.miniseries.model;


import jakarta.persistence.*;


import lombok.Data;

@Entity
@Data
@Table(name="miniseries")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    @Column(name="amount_of_awards")
    private Integer amountOfAwards;

}
