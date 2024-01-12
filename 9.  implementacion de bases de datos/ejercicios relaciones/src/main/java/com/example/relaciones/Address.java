package com.example.relaciones;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Long id;
    private String city;
    @OneToOne(mappedBy = "address")
    private User user;
}
