package meli.bootcamp.jpa.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "genres")
public class Genre {
  @Id
  private Integer id;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "name")
  private String name;

  @Column(name = "ranking")
  private Integer ranking;

  @Column(name = "active")
  private Boolean active;
}
