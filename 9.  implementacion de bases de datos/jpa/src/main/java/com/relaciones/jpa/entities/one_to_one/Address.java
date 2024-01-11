package com.relaciones.jpa.entities.one_to_one;

import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToOne(mappedBy = "address")
    private User user;
}
