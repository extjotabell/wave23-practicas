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
public class Seasons {

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
    @Column(name = "number")
    private Integer number;
    @Basic
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Basic
    @Column(name = "end_date")
    private LocalDate endDate;
    /*@Basic
    @Column(name = "serie_id")
    private Integer serieId;*/
    @OneToMany(mappedBy = "seasonsBySeasonId")
    private List<Episodes> episodesById;
    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    private Series seriesBySerieId;
}
