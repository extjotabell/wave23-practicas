package com.example.llavescompuestas.model;

import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
public class CompraKey implements Serializable {
    private Long id;
    private LocalDate fecha;
}
