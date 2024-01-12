package com.example.clavecompuesta;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table (name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {
    private int id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;
    @Id
    private LocalDate fecha;
}
