package com.meli.sqlshowroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clothes")
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    private String brand;
    private String color;
    private Integer stock;
    @Column(name = "selling_price")
    private Double sellingPrice;
    @ManyToOne
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;
}
