package com.example.relaciones;

import jakarta.persistence.*;

@Entity
@Table (name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "cart_id", nullable = false)
    private Cart cart;
}
