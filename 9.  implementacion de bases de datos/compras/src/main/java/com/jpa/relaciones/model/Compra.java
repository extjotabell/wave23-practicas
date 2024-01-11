package com.jpa.relaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table (name = "compras")
@IdClass(value= CompraKey.class)
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private LocalDate Date;

    private Double total;
}
