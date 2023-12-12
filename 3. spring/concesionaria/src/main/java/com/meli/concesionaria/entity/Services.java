package com.meli.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Services {
    private String date;
    private double kilometers;
    private String descriptions;
}
