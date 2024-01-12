package com.mercadolibre.hql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genres {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Basic
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "ranking")
    private Integer ranking;
    @Basic
    @Column(name = "active")
    private byte active;
    @OneToMany(mappedBy = "genresByGenreId")
    private List<Movies> moviesById;
    @OneToMany(mappedBy = "genresByGenreId")
    private List<Series> seriesById;
}
