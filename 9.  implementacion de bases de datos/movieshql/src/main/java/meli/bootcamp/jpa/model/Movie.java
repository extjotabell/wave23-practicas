package meli.bootcamp.jpa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
  @Id
  private Integer id;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "title")
  private String title;

  @Column(name = "rating")
  private BigDecimal rating;

  @Column(name = "awards")
  private Integer awards;

  @Column(name = "release_date")
  private LocalDateTime releaseDate;

  @Column(name = "length")
  private Integer length;

  @ManyToOne
  @JoinColumn(name = "genre_id")
  private Genre genre;
}
