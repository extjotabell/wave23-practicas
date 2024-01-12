package com.example.relaciones;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.Set;

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruedas;

    @OneToMany(mappedBy = "cart")
    private Set<AbstractReadWriteAccess.Item> items;
}
