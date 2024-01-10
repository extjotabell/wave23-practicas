package com.example.MiniSeries.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private Integer amountOfAwards;
}
