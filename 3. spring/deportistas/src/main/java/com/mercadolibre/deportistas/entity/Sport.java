package com.mercadolibre.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Getter
public class Sport {
    String name;
    String level;
}
