package com.example.relacionesJPA.entities.claveCompuesta2;

import com.example.relacionesJPA.entities.claveCompuesta.PersonaKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Long id;

    @Id
    private LocalDate fecha;
}
