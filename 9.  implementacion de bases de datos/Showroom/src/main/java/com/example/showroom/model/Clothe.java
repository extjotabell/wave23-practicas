package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clothes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    @Column(name = "sale_price")
    private Double salePrice;

    public Clothe(String name, String type, String brand, String color, String size, Integer quantity, Double salePrice) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.salePrice = salePrice;
    }
}
