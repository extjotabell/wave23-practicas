package org.ejercicio.hql.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seasons")
public class Season {
    @Id
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Double number;
    private LocalDate releasDate;
    private LocalDate endate;
    private Integer serieId;
}
