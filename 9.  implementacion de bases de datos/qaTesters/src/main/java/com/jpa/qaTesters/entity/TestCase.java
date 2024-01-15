package com.jpa.qaTesters.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(fluent = true)
@Entity
@Table(name = "testcases")
public class TestCase {
    @Id
    @Column( name = "id")
    Long idCase;
    @Column(nullable = false, length = 300)
    String description;
    @Column(nullable = false)
    Boolean tested;
    @Column(nullable = false)
    Boolean passed;
    @Column( name = "number_of_tries", nullable = false)
    Integer numberOfTries;
    @Column( name = "last_update", nullable = false)
    LocalDate lastUpdate;
}
