package com.example.llavescompuestas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
@Getter
@Setter
public class Compra {

    @Id
    private Long id;
    @Id
    private LocalDate fecha;
}
