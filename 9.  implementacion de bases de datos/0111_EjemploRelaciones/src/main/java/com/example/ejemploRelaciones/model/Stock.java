package com.example.ejemploRelaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    private Long id;
    private Date fechaHora;
    private Integer cantidad;

}
