package com.ejercicio.showroom.dto;

import com.ejercicio.showroom.model.Clothes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class SaleDTO {
    @JsonIgnore
    private Long number;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<Clothes> clothes;
}
