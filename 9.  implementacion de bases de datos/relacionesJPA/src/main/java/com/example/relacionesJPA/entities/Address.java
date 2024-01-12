package com.example.relacionesJPA.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String street;
    private String city;

    //El atributo mappedBy se usa para indicar que la variable “address” del lado de la clase User es
    // quien establece la relación
    @OneToOne(mappedBy = "address")
    private User user;
}
