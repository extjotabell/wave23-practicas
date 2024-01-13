package com.ejercicio.Movies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(name = "release_date")
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    @Column(name = "end_date")
    @JsonProperty("end_date")
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonProperty("genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "serie")
    @JsonIgnore
    private List<Season> seasons;

}
