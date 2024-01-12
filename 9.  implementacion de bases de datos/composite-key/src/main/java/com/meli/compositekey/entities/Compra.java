package com.meli.compositekey.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table (name = "compras")
@IdClass(value = CompraKey.class)
@AllArgsConstructor
@NoArgsConstructor
public class Compra {
    @Id
    private int clienteId;
    @Id
    private LocalDate fecha;
    private Double total;
}
