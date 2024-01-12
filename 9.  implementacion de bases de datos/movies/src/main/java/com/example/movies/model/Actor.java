package com.example.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    @Column
    Date created_at;
    @Column
    Date updated_at;
    @Column
    String first_name;
    @Column
    String last_name;
    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_movie_id")
    private Movie favoriteMovie;

}
