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
public class Series {

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
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Basic
    @Column(name = "end_date")
    private LocalDate endDate;
    /*@Basic
    @Column(name = "genre_id")
    private Integer genreId;*/
    @OneToMany(mappedBy = "seriesBySerieId")
    private List<Seasons> seasonsById;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genres genresByGenreId;
}
