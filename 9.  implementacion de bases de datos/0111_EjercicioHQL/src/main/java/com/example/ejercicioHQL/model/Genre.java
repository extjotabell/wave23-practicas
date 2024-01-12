package com.example.ejercicioHQL.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "genres")
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    private String name;
    private Integer ranking;
    private boolean active;

    @OneToMany(mappedBy = "genre")
    private Set<Series> seriesSet;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies;

}

