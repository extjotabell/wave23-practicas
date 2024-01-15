package com.meli.showroom.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clothes")
public class Clothes {
    @Id
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer amount;
    @Column(name = "selling_price")
    private Double sellingPrice;
}