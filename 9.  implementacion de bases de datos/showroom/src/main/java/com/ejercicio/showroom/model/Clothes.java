package com.ejercicio.showroom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    @Column(name = "sale_price")
    @JsonProperty("sale_price")
    private Double salePrice;
}
