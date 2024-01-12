package com.mercadolibre.hql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Episodes {

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
    @Column(name = "rating")
    private Double rating;
    /*@Basic
    @Column(name = "season_id")
    private Integer seasonId;*/
    @OneToMany(mappedBy = "episodesByEpisodeId")
    private List<ActorEpisode> actorEpisodesById;
    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private Seasons seasonsBySeasonId;
}
