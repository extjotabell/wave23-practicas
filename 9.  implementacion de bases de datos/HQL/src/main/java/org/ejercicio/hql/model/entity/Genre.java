package org.ejercicio.hql.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "genres")
public class Genre {
    @Id
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String name;
    private Integer ranking;
    private Integer Short;
}
