package com.mercadolibre.covid19.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    private Integer code;
    private String symptomName;
    private String severity_level;
}

