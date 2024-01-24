package com.mercadolibre.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDTO {
    String name;
    String lastName;
    SportDTO sport;
}
