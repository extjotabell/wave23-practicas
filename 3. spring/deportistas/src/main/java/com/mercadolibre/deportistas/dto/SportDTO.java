package com.mercadolibre.deportistas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SportDTO {
    String name;
    String level;

    public SportDTO(String name) {
        this.name = name;
    }
}


