package com.spring.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Food {
    private String name;
    private Double calories; //cada 100gr
}
