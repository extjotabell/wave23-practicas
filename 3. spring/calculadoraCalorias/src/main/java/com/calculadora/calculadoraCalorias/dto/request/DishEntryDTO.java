package com.calculadora.calculadoraCalorias.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DishEntryDTO {
    private String name;
    private int weight;
}
