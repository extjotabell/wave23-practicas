package com.mercadolibre.covid19.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SymptomsDto {
    private List<SymptomDto> symptoms;
}
