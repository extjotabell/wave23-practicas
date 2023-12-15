package com.mercadolibre.covid19.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDto {
    private Long code;
    private String symptomName;
    private String severity_level;
}
