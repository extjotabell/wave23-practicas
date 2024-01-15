package com.meli.PracticeHQL.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "movies")
@Getter @Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "awards")
    private Integer awards;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "length")
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
