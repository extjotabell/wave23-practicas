package com.bootcamp.compositekey.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
@Getter @Setter
public class Compra {

    @Id
    @Column(name = "cliente_id")
    private Long clienteId;

    @Id
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    private Double importe;

}
