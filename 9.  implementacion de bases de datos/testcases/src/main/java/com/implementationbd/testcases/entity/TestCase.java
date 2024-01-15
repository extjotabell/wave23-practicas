package com.implementationbd.testcases.entity;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_case")
    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    @Column(name = "number_of_tries")
    int numberOfTries;
    @Column(name = "last_update")
    LocalDate lastUpdate;
}
