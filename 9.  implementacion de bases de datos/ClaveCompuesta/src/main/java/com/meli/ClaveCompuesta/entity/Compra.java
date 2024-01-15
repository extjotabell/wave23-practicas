package com.meli.ClaveCompuesta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@IdClass(CompraKey.class)
@Table
public class Compra {

    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;

}
