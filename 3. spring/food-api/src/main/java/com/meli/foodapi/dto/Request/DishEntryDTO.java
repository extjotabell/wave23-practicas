package com.meli.foodapi.dto.Request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DishEntryDTO {
    private String name;
    private int weight;
}
