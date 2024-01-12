package com.example.relacionesJPA.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    //name : indica el nombre que va a tener la columna en nuestra
    // tabla de la BD.

    //referencedColumnName: Indica el nombre del atributo de la otra
    // tabla que queremos relacionar.
}
