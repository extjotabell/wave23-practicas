package com.practice.movies.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Integer ranking;
    private Integer active;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
