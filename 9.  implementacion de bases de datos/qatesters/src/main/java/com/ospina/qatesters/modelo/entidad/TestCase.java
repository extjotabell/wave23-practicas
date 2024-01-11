package com.ospina.qatesters.modelo.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "test_case")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_case")
    Long idCase;
    String description;
    Boolean tested;
    Boolean passed;
    @Column(name = "number_of_tries")
    Integer numberOfTries;
    @Column(name = "last_update")
    LocalDate lastUpdate;
}
