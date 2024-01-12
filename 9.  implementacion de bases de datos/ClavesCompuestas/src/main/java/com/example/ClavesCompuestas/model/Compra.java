package com.example.ClavesCompuestas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="compras")
@Setter
@Getter
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Integer clienteId;
    @Id
    private LocalDate fecha;
}
